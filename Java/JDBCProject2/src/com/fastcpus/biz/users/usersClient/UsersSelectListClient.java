package com.fastcpus.biz.users.usersClient;

import com.fastcpus.biz.users.UsersDAO;
import com.fastcpus.biz.users.UsersVO;

import java.util.List;

public class UsersSelectListClient {
    public static void main(String[] args) {
        UsersDAO dao = new UsersDAO();
        List<UsersVO> userList = dao.getUserList();
        System.out.println("현재 사용자는 모두 "+userList.size()+"건 조회됐습니다.");
    }
}
