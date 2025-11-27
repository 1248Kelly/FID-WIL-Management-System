/**
 * InternshipTrackingSystem
 * InternshipPostRepository.java
 * Author : Thapelo Ngwenya - 222260971
 * Date : 06 October 2025
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.InternshipPost;

import java.util.Date;
import java.util.List;

@Repository
public interface InternshipPostRepository extends JpaRepository<InternshipPost, Integer> {

    List<InternshipPost> findByStatus(String status);

    List<InternshipPost> findByDeadlineAfter(Date date);

    // Use the correct path: InternshipPost.business.id and Long type for the Business id
    List<InternshipPost> findByBusiness_Id(Long businessId);

    @Modifying
    @Transactional
    void deleteByBusiness_Id(Long businessId);
}
