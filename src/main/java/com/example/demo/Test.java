package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//データベーステーブル「test」に対応するエンティティクラス
@Entity
@Table(name = "test") // テーブル名を指定
public class Test {
 
 // idカラムに対応するフィールド
 @Id // 主キーを指定
 @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動増分の設定
 private int id;

 // nameカラムに対応するフィールド
 private String name;

 // コンストラクタ
 public Test() {}

 // 引数付きコンストラクタ
 public Test(int id, String name) {
     this.id = id;
     this.name = name;
 }

 // idフィールドのgetterメソッド
 public int getId() {
     return id;
 }

 // idフィールドのsetterメソッド
 public void setId(int id) {
     this.id = id;
 }

 // nameフィールドのgetterメソッド
 public String getName() {
     return name;
 }

 // nameフィールドのsetterメソッド
 public void setName(String name) {
     this.name = name;
 }
}