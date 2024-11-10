package com.example.demo;

import java.util.List;
import java.util.Optional;

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
    
    // 特定のIDのTestエンティティのnameを編集するメソッド
    public void editTest(Integer id, String name) {
        // idに基づいてエンティティを取得
        Optional<Test> optionalTest = testRepository.findById(id);
        
        // エンティティが存在する場合、nameを更新し保存
        if (optionalTest.isPresent()) {
            Test test = optionalTest.get();
            test.setName(name); // nameを更新
            testRepository.save(test); // 更新したエンティティを保存
        } else {
            throw new IllegalArgumentException("指定されたIDのTestエンティティは存在しません。");
        }
    }
    
    // 特定のIDのTestエンティティを削除するメソッド
    public void deleteTest(Integer id) {
        // idに基づいてエンティティの存在を確認し、存在する場合に削除
        if (testRepository.existsById(id)) {
            testRepository.deleteById(id); // データベースから削除
        } else {
            throw new IllegalArgumentException("指定されたIDのTestエンティティは存在しません。");
        }
    }
}
