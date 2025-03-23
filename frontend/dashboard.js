document.addEventListener("DOMContentLoaded", async function () {
    const donorName = document.getElementById("donorName");
    const donorEmail = document.getElementById("donorEmail");
    const bloodType = document.getElementById("bloodType");
    const lastDonation = document.getElementById("lastDonation");
    const eligibility = document.getElementById("eligibility");
    const logoutBtn = document.getElementById("logoutBtn");

    

    try {
        const response = await fetch("http://localhost:8080/api/donors/me", {
            method: "GET",
            headers: { 
                "Content-Type": "application/json"
            }
        });

        const data = await response.json();

        if (response.ok) {
            donorName.textContent = data.name;
            donorEmail.textContent = data.email;
            bloodType.textContent = data.bloodType;
            lastDonation.textContent = data.lastDonationDate;
            eligibility.textContent ="Yes";
        } else {
            alert("Failed to load donor details.");
            window.location.href = "login.html"; // Redirect if fetch fails
        }
    } catch (error) {
        console.error("Error loading dashboard:", error);
        alert("Error fetching data.");
        window.location.href = "login.html";
    }

    // Logout Functionality
    logoutBtn.addEventListener("click", function () {
        localStorage.removeItem("token");
        alert("Logged out successfully.");
        window.location.href = "login.html";
    });
});
