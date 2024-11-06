package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private TestService testService;

    // メインページの表示
    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("message", "ようこそ！Todoアプリへ");
        return "index"; // main.htmlテンプレートを返す
    }

    // Todoリストページへの遷移
    @GetMapping("/test")
    public String showTodoListPage(Model model) {
        return "test"; // test.htmlテンプレートを返す
    }

    @GetMapping("/get")
    public String test(Model model) {
        // データベースからデータを取得
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);

        // コンソールに取得した結果を表示
        for (Test test : tests) {
            System.out.println("ID: " + test.getId() + ", Name: " + test.getName());
        }
        return "get"; // get.htmlテンプレートを返す
    }

    // データ追加の処理
    @PostMapping("/add")
    public String addTest(@RequestParam("name") String name) {
        // nameをTestServiceに渡して保存
        testService.saveTest(name);
        return "redirect:/get"; // データ一覧ページにリダイレクト
    }
}
