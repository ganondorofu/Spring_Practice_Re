package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    // 全てのTestエンティティを取得するメソッド
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // 新しいTestエンティティを保存するメソッド
    public void saveTest(String name) {
        // Testオブジェクトを作成し、nameをセット
        Test test = new Test();
        test.setName(name);
        testRepository.save(test); // データベースに保存
    }
}
