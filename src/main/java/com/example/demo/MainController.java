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
        return "index"; // index.htmlテンプレートを返す
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
        return "get"; // get.htmlテンプレートを返す
    }

    // データ追加の処理
    @PostMapping("/add")
    public String addTest(@RequestParam("name") String name) {
        testService.saveTest(name);
        return "redirect:/get";
    }
    
    // データ編集の処理
    @PostMapping("/edit")
    public String editTest(@RequestParam("id") Integer id, @RequestParam("name") String name, Model model) {
        try {
            testService.editTest(id, name);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "指定されたIDのデータが存在しません。");
            return test(model); // エラーメッセージ付きで一覧ページに戻る
        }
        return "redirect:/get";
    }
    
    // データ削除の処理
    @PostMapping("/delete")
    public String deleteTest(@RequestParam("id") Integer id, Model model) {
        try {
            testService.deleteTest(id);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "指定されたIDのデータが存在しません。");
            return test(model);
        }
        return "redirect:/get";
    }
}
