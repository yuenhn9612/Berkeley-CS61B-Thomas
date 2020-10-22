
package test2;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;
import javax.swing.JTextPane;
 
public class test2 extends JFrame {
 
	private JPanel contentPane;
	private JTextPane numberField;
	private JTextField sumField;
	private JTextField aveField;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 frame = new test2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public test2() {
		super("第二次实验");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numberField = new JTextPane();
		numberField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				double sum = 0,avg = 0;
				switch(e.getKeyChar()) {
				case KeyEvent.VK_SPACE: //分隔符为空格
				case KeyEvent.VK_COMMA: //分隔符为英文逗号
				case KeyEvent.VK_ENTER: //分隔符为回车
					String str=numberField.getText();
					StringTokenizer analyze = new StringTokenizer(str," ,\n");
					int allnum=analyze.countTokens();
					for(int i =0;i<allnum;i++) {
						String temp = analyze.nextToken();  //字符串分割解析工具
						sum = sum+Double.parseDouble(temp);
					}
					if(allnum>0) {
						avg = sum/allnum;
					}else {
						avg = 0;
					}
					sumField.setText(Double.toString(sum));
					aveField.setText(Double.toString(avg));
				}
			}
		});
		numberField.setBounds(14, 13, 349, 101);
		contentPane.add(numberField);
	
		JLabel label = new JLabel("和　值");
		label.setBounds(57, 140, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("平均值");
		label_1.setBounds(57, 182, 72, 18);
		contentPane.add(label_1);
		
		sumField = new JTextField();
		sumField.setBounds(130, 137, 233, 24);
		contentPane.add(sumField);
		sumField.setColumns(10);
		
		aveField = new JTextField();
		aveField.setBounds(130, 179, 233, 24);
		contentPane.add(aveField);
		aveField.setColumns(10);
	}
}