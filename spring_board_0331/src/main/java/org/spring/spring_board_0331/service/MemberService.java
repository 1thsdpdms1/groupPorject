package org.spring.spring_board_0331.service;

import lombok.RequiredArgsConstructor;
import org.spring.spring_board_0331.service.serviceImpl.MemberServiceImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberServiceImpl {

    private final MemberService memberService;



}
