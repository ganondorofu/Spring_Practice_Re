// TestRepository.java
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Testエンティティに対応するリポジトリ
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    // 必要であれば追加のクエリメソッドを定義
}
