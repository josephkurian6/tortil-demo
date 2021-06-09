package com.tortil.bank.demo.repository;

import com.tortil.bank.demo.entity.Branch;
import com.tortil.bank.demo.model.BranchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>JPA Repository for branch CRUD operations and also consist of project based row retrieval</p>
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    /**
     * Query on branch and retrieve data using project
     * @param ifscCode
     * @return Branch DTO/Model.
     */
    @Query("select new com.tortil.bank.demo.model.BranchModel(BR.ifsc, BR.branch, B.name, " +
            "BR.address, BR.city, BR.district, BR.state) from Branch BR join BR.bank B where BR.ifsc = :ifscCode")
    BranchModel getBranch(@Param("ifscCode") String ifscCode);
}
