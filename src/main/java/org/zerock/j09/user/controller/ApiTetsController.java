package org.zerock.j09.user.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.j09.user.dto.MemberDTO;

@RestController
@Log4j2
@RequestMapping("/api/board")
public class ApiTetsController {
    @GetMapping("/list")
    public String[] getList(@AuthenticationPrincipal MemberDTO dto) {

        log.info("---------------" + dto);
        log.info("username : " + dto.getUsername());
        log.info("password : " + dto.getPassword());

        return new String[]{"AAA","BBB","CCC"};
    }

    @PreAuthorize("principal.username = #writer")
    @GetMapping("/delete")
    public String[] delete(Long bno, String writer) {

        log.info("delete : " + bno);
        log.info("writer : " + writer);

        return new String[]{"DEL","DEL","DEL"};
    }
}
