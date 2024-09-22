package org.example;

import org.example.LinkedList.*;

import java.util.NoSuchElementException;
import org.example.Queue.*;
import org.example.Stack.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("LinkedList 테스트\n");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println("\n*유효하지 않은 리스트 삭제시*");
        try {
            linkedList.delete(0);
            linkedList.delete(-1);
        } catch(NoSuchElementException e){
            System.out.println("유효하지 않은 인덱스입니다.\n");
        }

        System.out.println("*데이터 추가*");

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.print();

        System.out.println("\n*데이터 리턴*");
        System.out.println("0 번째 데이터 : " + linkedList.get(0));
        System.out.println("\n*데이터 삭제 후*");
        linkedList.delete(0);
        System.out.println("0 번째 데이터 : " + linkedList.get(0));

        System.out.println("\nQueue 테스트");
        Queue<Integer> queue = new Queue<Integer>();

        System.out.println("*데이터 추가 전*");
        System.out.println("Queue Empty : " + queue.empty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("\n*데이터 추가 후*");
        System.out.println("맨 앞 데이터 : " + queue.front());

        System.out.println("\n*데이터 삭제 중*");
        while(!queue.empty()) {
            System.out.println("삭제 데이터 : " + queue.front());
            queue.dequeue();
        }

        System.out.println("\n*데이터 삭제 후*");
        System.out.println("Queue Empty : " + queue.empty());

        System.out.println("\n*비어있는 큐 삭제시*");
        try {
            queue.dequeue();
        } catch(NoSuchElementException e){
            System.out.println("큐가 비어있습니다.\n");
        }

        System.out.println("\nStack 테스트");
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("*데이터 추가 전*");
        System.out.println("Stack Empty : " + stack.empty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("\n*데이터 추가 후*");
        System.out.println("맨 앞 데이터 : " + stack.top());

        System.out.println("\n*데이터 삭제 중*");
        while(!stack.empty()) {
            System.out.println("삭제 데이터 : " + stack.top());
            stack.pop();
        }

        System.out.println("\n*데이터 삭제 후*");
        System.out.println("Stack Empty : " + stack.empty());

        System.out.println("\n*비어있는 스택 삭제시*");
        try {
            stack.pop();
        }
        catch (NoSuchElementException e){
            System.out.println("스택이 비어있습니다.\n");
        }
    }
}