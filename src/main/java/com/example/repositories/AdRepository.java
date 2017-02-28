package com.example.repositories;

import com.example.domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Teddy on 2017-02-08.
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByUserId(long userId);
    Ad findByAdId(long id);
    Ad findByDescription(String searchString);
}
