package com.mysite.nexfilx.Contents.dao;

import com.mysite.nexfilx.Contents.domain.NetflixContentDetails;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ContentRepository extends JpaRepository<NetflixContents, Long> {
    List<NetflixContents> findByContentNumContaining(String keyword);
    List<NetflixContents> findByContentNameContaining(String keyword);

    List<NetflixContentDetails> findByContentNum(String keyword);


}
