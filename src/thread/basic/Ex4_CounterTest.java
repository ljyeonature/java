package thread.basic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex4_CounterTest extends JFrame{
    private JPanel p1, p2;
    private JButton btn;
    private JTextArea ta;
    private JLabel lb;
    private boolean inputChk = false;
    
    public Ex4_CounterTest() {
        setTitle("단일 스레드 테스트!");
        p1 = new JPanel();
        p1.add(btn = new JButton("Click"));
        p1.add(lb = new JLabel("Count!"));//추가 
        add(p1, BorderLayout.NORTH);
        
        p2 = new JPanel();       
        p2.add( ta = new JTextArea(20,50));
        add(p2, BorderLayout.CENTER);
        
        setBounds(200, 200, 600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // 1- 카운트 다운을 시작하는 스레드 
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=10; i>0; i--){
                            // inputChk = true -> 카운트 중지
                            if(inputChk) {
                                lb.setText("빙고");
                                inputChk = false;
                                return;
                            }
                            lb.setText(String.valueOf(i));
                            try{
                                Thread.sleep(1000);
                            }catch(Exception ex){}
                        }
                    }
                }).start();
            	
                // 2- 입력값을 받아서 JTextArea에 붙이는 작업 
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String input = JOptionPane.showInputDialog("인사말 입력->");
                        ta.append("입력값 : " + input + "입니다\n");
                        inputChk = true;
                    }
                }).start();
   
            }
        });
    }
    public static void main(String[] args) {
        new Ex4_CounterTest();
    }
}
