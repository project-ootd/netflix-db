package com.mysite.nexfilx.likelist.repository;

import com.mysite.nexfilx.Contents.domain.NetflixContents;

import java.util.List;

public interface LikeListRepositoryCustom {
    List<NetflixContents> getQslUserLike(Long id);
//    boolean getQslUserCheckIcon(Long id);
}
