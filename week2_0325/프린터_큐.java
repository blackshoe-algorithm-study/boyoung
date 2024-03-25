package week2_0325;

import java.io.IOException;

public class 프린터_큐 {
    public static void main(String[] args) throws IOException{
        //queue에 중요도를 순서대로 넣기
        //queue에서 하나 poll해서 queue 안에 있는 다른 원소들의 중요도와 비교
        //비교했을때, poll한 것보다 더 큰 중요도가 있으면 offer하여 큐의 마지막에 다시 추가
        //poll한 것보다 큰게 없으면 인쇄된 것으로 간주하여 count++(default=0)하기
        //인쇄된 것 중 원하는 원소의 중요도와 일치하는지 확인하기
        //일치한다면 break 후 count 출력
    }
}
