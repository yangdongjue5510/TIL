package com.fastcpus.biz.users.usersClient;

import com.fastcpus.biz.users.UsersDAO;
import com.fastcpus.biz.users.UsersVO;

import java.util.Scanner;

public class UsersInsertClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersVO vo = new UsersVO();
        vo.setId(scanner.nextLine());
        vo.setPassword(scanner.nextLine());
        vo.setName(scanner.nextLine());
        vo.setRole(scanner.nextLine());

        UsersDAO dao = new UsersDAO();
        dao.insertUser(vo);
        dao.getUserByName(vo);
    }
}
