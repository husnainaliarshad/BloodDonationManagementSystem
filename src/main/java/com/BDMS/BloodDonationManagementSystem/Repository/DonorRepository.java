import org.springframework.data.mongodb.repository.MongoRepository;
import com.BDMS.BloodDonationManagementSystem.Model.Donor;
import java.util.Optional;

public interface DonorRepository extends MongoRepository<Donor, String> {
    Optional<Donor> findByEmail(String email);

    // ✅ Prevent duplicate email registrations
    boolean existsByEmail(String email);
}
