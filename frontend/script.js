document.addEventListener("DOMContentLoaded", function () {
    // ✅ Select all necessary elements
    const loginForm = document.querySelector("#loginForm form");
    const signupForm = document.querySelector("#signupForm form");
    const errorMessage = document.createElement("p");
    errorMessage.style.color = "red";
    errorMessage.style.textAlign = "center";

    const btnLogin = document.getElementById("btnLogin");
    const btnSignup = document.getElementById("btnSignup");
    const loginPanel = document.getElementById("loginForm");
    const signupPanel = document.getElementById("signupForm");

    // ✅ Toggle between Login & Signup panels
    btnLogin.addEventListener("click", function () {
        loginPanel.classList.remove("hidden");
        signupPanel.classList.add("hidden");
    });

    btnSignup.addEventListener("click", function () {
        signupPanel.classList.remove("hidden");
        loginPanel.classList.add("hidden");
    });

    // ✅ Handle Login Form Submission
    loginForm.addEventListener("submit", async function (event) {
        event.preventDefault(); // Prevent default form submission

        const emailVAR = document.getElementById("loginEmail").value;
        const passwordVAR = document.getElementById("loginPassword").value;

        try {
            const response = await fetch("http://localhost:8080/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ "email": emailVAR, "password": passwordVAR }), // Explicit key-value pairs
            });
        
            console.log("Response Status:", response.status); // Debugging
        
            // ✅ Check if response is not empty before parsing JSON
            let data;
            try {
                data = await response.json();
            } catch (error) {
                console.error("Error parsing JSON:", error);
                showError(loginForm, "Unexpected server response.");
                return;
            }
        
            console.log("Response Data:", data); // Debugging
        
            if (response.ok && data.token) {
                localStorage.setItem("token", data.token);
                alert("Login successful!");
                window.location.href = "dashboard.html";
            } else {
                showError(loginForm, data.message || "Invalid credentials.");
            }
        } catch (error) {
            console.error("Fetch error:", error);
            showError(loginForm, "Server error. Please try again.");
        }
        
    });

    // ✅ Handle Signup Form Submission
    signupForm.addEventListener("submit", async function (event) {
        event.preventDefault();

        const firstName = document.getElementById("fname").value;
        const lastName = document.getElementById("lname").value;
        const username = document.getElementById("username").value;
        const dob = document.getElementById("dob").value;
        const gender = document.getElementById("gender").value;
        const email = document.getElementById("signupEmail").value;
        const password = document.getElementById("signupPassword").value;
        const confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            showError(signupForm, "Passwords do not match!");
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/api/auth/signup", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    firstName,
                    lastName,
                    username,
                    dob,
                    gender,
                    email,
                    password,
                }),
            });

            const data = await response.json();

            if (response.ok) {
                alert("Signup successful! Please log in.");
                btnLogin.click(); // Switch to login panel
            } else {
                showError(signupForm, data.message || "Signup failed.");
            }
        } catch (error) {
            showError(signupForm, "Server error. Please try again.");
        }
    });

    // ✅ Function to Display Error Messages
    function showError(form, message) {
        errorMessage.textContent = message;
        form.appendChild(errorMessage);
    }
});
