package com.example.demo; // 追加する行

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // メインページの表示
    @GetMapping("/")
    public String showMainPage(Model model) {
        // モデルに必要なデータを追加（例：メッセージや設定など）
        model.addAttribute("message", "ようこそ！Todoアプリへ");
        return "index"; // main.htmlテンプレートを返す
    }

    // Todoリストページへの遷移
    @GetMapping("/test")
    public String showTodoListPage(Model model) {
        // Todoリストのデータを追加する場合は、ここでサービスを呼び出すことができます
        // model.addAttribute("todos", todoService.findAll());
        return "test"; // todo-list.htmlテンプレートを返す
    }
}
