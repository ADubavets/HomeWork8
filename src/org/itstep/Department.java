package org.itstep;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Department extends LinkedList {
    private String nameDepartment;
    private List<Letter> letters = new LinkedList<>();

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public void addLetter(Letter letter){
        letters.add(letter);
    }

    public void sortLetterDep(){
        Collections.sort(letters);
    }

    public String toString(){
        StringBuilder sb = new  StringBuilder();
        sb.append(nameDepartment + " Исходящие документы: \n");
        for (Letter letter: letters)
            sb.append(letter.toStringLetter());
        return  sb.toString();
    }
}
