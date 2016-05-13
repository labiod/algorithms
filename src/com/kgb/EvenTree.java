package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/19/16.
 */
public class EvenTree {

    private static class Node<T> {
        T mData;
        Node<T> mParent;
        LinkedList<Node<T>> children;

        public Node(T data) {
            this(null, data);
        }
        public Node(Node<T> parent, T data) {
            mData = data;
            mParent = parent;
            children = new LinkedList<Node<T>>();

        }

        public void add(T child) {
            children.add(new Node<T>(child));
        }

        public Node<T> find(T parent) {
            for(Node<T> child : children) {
                if(child.mData == parent) {
                    return child;
                }
                Node<T> node = child.find(parent);
                if(node != null) {
                    return node;
                }
            }
            return null;
        }

        public int getDegree() {
            int degree = 1;
            for(Node<T> child : children) {
                degree += child.getDegree();
            }
            return degree;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int N = sc.nextInt();
        int M = sc.nextInt();
        Node<Integer> root = new Node<Integer>(1);
        for(int i = 0; i < M; ++i) {
            int child = sc.nextInt();
            int parent = sc.nextInt();
            addToTree(child, parent ,root);
        }
        int edges = docomposedTree(root);
        System.out.println(edges);
    }

    private static int docomposedTree(Node<Integer> root) {
        int edges = 0;
        for(Node<Integer> child : root.children) {
            if(child.getDegree() % 2 == 0) {
                edges++;
            }
            edges += docomposedTree(child);
        }
        return edges;
    }

    private static void addToTree(int child, int parent, Node<Integer> tree) {
        if(tree.mData == parent) {
            tree.add(child);
        } else {
            Node<Integer> parentNode = tree.find(parent);
            parentNode.add(child);
        }
    }
}
