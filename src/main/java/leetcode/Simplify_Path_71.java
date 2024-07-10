package leetcode;

import java.util.Stack;

public class Simplify_Path_71 {
    public String simplifyPath(String path) {
        var stack = new Stack<String>();

        String[] folders = path.replaceAll("/{2,}", "/").split("/");

        for (var folder: folders){
            if (folder.equals("..")) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            if (folder.equals(".") || folder.isEmpty()) {
                continue;
            }

            stack.push(folder);
        }

        return "/" + String.join("/", stack);
    }
}
