package org.example

fun validParentheses(input: String): Boolean{

    if(input=="") {
        return true
    }

    val parentheses = hashMapOf(')' to '(', ']' to '[', '}' to '{')

    val stack = MyStack<Char>()

    for(letter in input){
        if(parentheses.containsValue(letter)){
            stack.push(letter)
        } else if(stack.peek() != parentheses[letter]){
            return false
        } else{
            stack.pop()
        }
    }

    return stack.isEmpty()
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    print(validParentheses("{}[()]"))

}