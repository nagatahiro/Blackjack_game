package jp.ac.uryukyu.ie.e225740;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    //52までの数字を点数に変換する
    public static int CoPoint(int x){
        int number = x % 13;
        if(number == 0) {
            number = 13;
        }
        if(number==11||number==12||number==13){
            number = 10;
        }
     
        return number;        
    }
    //1,11,12,13をA,J,Q,Kに変換するメソッド
    public static String toRank(int x) {
        int number = x % 13;
        if(number == 0) {
            number = 13;
        }
        switch(number) {
        case 1:
            return "A";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        default:
            String str = String.valueOf(number);
            return str;
        }
    }
    //リスト内の合計数を求めるメソッド
    public static int sumPoint(List<Integer> list) {
        int sum = 0;
     
        for(int i =0;i < list.size();i++) {
            sum = sum + CoPoint(list.get(i));
        }
     
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println("----ゲーム開始-----");

        //山札をシャッフルする
        List <Integer> deck = new ArrayList<>(52);
        for(int i = 1; i <= 52; i++){
            deck.add(i);
        }
        Collections.shuffle(deck);
        
        //リスト内確認用 
        //System.out.println(deck);
        

        //プレイヤーの手札のリストとディーラーのリストを作成
        List <Integer> player = new ArrayList<>();//プレイヤーのリスト
        List <Integer> dealer = new ArrayList<>();//ディーラーのリスト

        //初めにそれぞれランダムで配られる、プレイヤー側のみ表示
        player.add(deck.get(0));
        dealer.add(deck.get(1));
        System.out.println("-----------------------------");
        System.out.println("あなたの引いたカードは"+ toRank(player.get(0)) +"です");
        System.out.println("合計ポイントは"+ sumPoint(player)+"です。");
        System.out.println("-----------------------------");

        //　---以下ループ---
        int dCount = 1;
        int dealerCo = 0;
        while(true){
            System.out.println("--"+dCount+"ターン目--");
            System.out.println("カードを引きますか？Yes:y or No:n");

            //入力の処理
            Scanner scan = new Scanner(System.in);
            String str = scan.next();

            if("n".equals(str)) {
                break;
            } else if("y".equals(str)) {

            //プレイヤーが引いた際の処理
            player.add(deck.get(dCount*2));
            System.out.println("-----------------------------");
            System.out.println("あなたの引いたカードは"+ toRank(player.get(dCount)) +"です");
            System.out.println("合計ポイントは"+ sumPoint(player)+"です。");
            System.out.println("-----------------------------");

            //ディーラー側のポイント数が17以下なら引く
            if (sumPoint(dealer)<17){
                dealer.add(deck.get(dCount*2+1));
            }else{
                dealerCo = 1;
            }
            if (sumPoint(dealer)>21){
                dealerCo = 2;
            }
            if (sumPoint(dealer)>21||sumPoint(player)>21){
                break;
            }

            dCount ++ ;
         
            } else {
                System.out.println("あなたの入力は" + str + " です。y か n を入力してください。");
            }
        }
        //ディーラー側の処理
        while(dealerCo==0){
            dCount ++;
            System.out.println("--"+dCount+"ターン目--");
            System.out.println("-----------------------------");
            System.out.println("ディーラーが一枚引きました");
            System.out.println("-----------------------------");
            dealer.add(deck.get(dCount*2));
            if(sumPoint(dealer)>17){
                dealerCo = 1;
            }
        }
        System.out.println("-----ゲーム終了-----");
        System.out.println("あなたの合計ポイントは"+sumPoint(player)+"ポイント");
        System.out.println("ディーラーの合計ポイントは"+sumPoint(dealer)+"ポイント");
        
        //勝敗の判定
        if (sumPoint(dealer)>21||sumPoint(player)>21){
            if (sumPoint(player)>21){
                if (sumPoint(dealer)>21){
                    System.out.println("引き分けです");   
                }else{
                    System.out.println("あなたの負けです");
                }
            }else{
                System.out.println("あなたの勝ちです");
            }
        }else{
            if(sumPoint(dealer)-sumPoint(player)>0){
                System.out.println("あなたの負けです");
            }else{
                if(sumPoint(dealer)-sumPoint(player)==0){
                    System.out.println("引き分けです");
                }else{
                    System.out.println("あなたの勝ちです"); 
                }
            }
        }
        /* 
        ディーラーの手札確認用
        System.out.println(sumPoint(dealer));        
        System.out.println(dealer);   
        */     

    

    }
    
}
