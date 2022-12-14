package com.mysite.nexfilx.Contents.service;

import com.mysite.nexfilx.Contents.dao.ContentRepository;
import com.mysite.nexfilx.Contents.domain.NetflixContentDetails;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import com.mysite.nexfilx.Contents.dto.NetflixDetailDto;
import com.mysite.nexfilx.Contents.dto.NetflixDto;
import com.mysite.nexfilx.User.dao.UserRepository;
import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.likelist.domain.LikeList;
import com.mysite.nexfilx.likelist.repository.LikeListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;

    private final UserRepository userRepository;

    private final LikeListRepository likeListRepository;



    public List<NetflixDto> getNetflixContentsByContentNum(String keyword) {
        return contentRepository.findByContentNumContaining(keyword).stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();
    }

    public List<NetflixDto> getNetflixContentsBySearch(String keyword) {
        return contentRepository.findByContentNameContaining(keyword).stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();
    }


    public List<NetflixDto> getNetflixContent() {
        return contentRepository.findAll().stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();

//        return contentRepository.findAll();
    }

    public List<NetflixDto> checkicon(String useremail) {

        // ????????? ?????? ????????? ????????? ??????????????? ????????????.
        List<NetflixContents> netflixContents = contentRepository.findAll();
        // ????????? ????????? email ?????? ?????? ?????? ??? ??? ?????? User??? ???????????????
        Optional<User> user = userRepository.findByUseremail(useremail);
        // ????????? ???????????? user??? id?????? ???????????? likelist??? ?????? ????????? ??? ??? ?????? ?????????.
        List<LikeList> likeLists = likeListRepository.findByUserId(user.get().getId());


        return netflixContents.stream()
            .map(contents -> {
                // ??????????????? boolean ?????? ???????????? ????????? ????????????????????? ????????? ?????? ??????????????? ???????????? ?????? boolean??? ?????? false??????.
                AtomicBoolean likeStatus = new AtomicBoolean();
                //  forEach?????? ????????? likeLists??? ????????? ???????????????.
                likeLists.forEach(likeList -> {
                    // ????????? ?????? cotentsID?????? ????????? true??? ??????????????? ?????????
                    if(likeList.getNetflixContents().getId() == contents.getId()){
                        likeStatus.set(true);
                    }
                });
                // bulider??? ???????????? likeStatus??? ?????? ???????????? ?????????.
                NetflixDto netflixDto = NetflixDto.builder()
                        .id(contents.getId())
                        .contentNum(contents.getContentNum())
                        .age(contents.getAge())
                        .contentImg(contents.getContentImg())
                        .contentName(contents.getContentName())
                        .contentVideo(contents.getContentVideo())
                        .actor(contents.getActor())
                        .director(contents.getDirector())
                        .mainStory(contents.getMainStory())
                        .likeStatus(likeStatus.get())
                        .detailImg(contents.getDetailImg())
                        .detailTextImg(contents.getDetailImg())
                        .episodes(contents.getEpisodes())
                        .date(contents.getDate())
                        .contentId(contents.getContentId())
                        .rankingImg(contents.getRankingImg())
                        .videoLink(contents.getVideoLink())

                        .build();

                return netflixDto;
            }).collect(Collectors.toList());

    }
    public List<NetflixContentDetails> detailcheck(Long id){
        Optional<NetflixContents> netflixContents = this.contentRepository.findById(id);
        List<NetflixContentDetails> netflixContentDetails = netflixContents.get().getDetails();
        return netflixContentDetails;
    }

    public List<NetflixDto> originSearch(){
        return contentRepository.findAll().stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();
    }
}