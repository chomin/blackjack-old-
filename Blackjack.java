package blackjack;

import java.util.Random;

import com.nttdocomo.io.ConnectionException;
import com.nttdocomo.ui.Canvas;
import com.nttdocomo.ui.Display;
import com.nttdocomo.ui.Font;
import com.nttdocomo.ui.Frame;
import com.nttdocomo.ui.Graphics;
import com.nttdocomo.ui.IApplication;
import com.nttdocomo.ui.Image;
import com.nttdocomo.ui.MediaImage;
import com.nttdocomo.ui.MediaManager;
import com.nttdocomo.ui.UIException;

/*
 * Blackjack.java
 *
 * DATE : 2014/01/04 19:05
 */


/**
 * Blackjack
 *
 * @author NAME
 */
public class Blackjack extends IApplication {
    
    
    public void start() {
	  Display.setCurrent(new MainCanvas(this));
    }
    
}

/**
 * MainCanvas
 *
 */
class MainCanvas extends Canvas {
    IApplication iapp;
    
    Image[] img,button;
    int cards[],number[];{	  //readonlyのcomputed propaty
	  
	  //カードを16枚格納
	  cards=new int[16];
	 		cards:	//forにタグ付け
	  for(int i=0;i<16;i++){
		Random rnd = new Random();
		int ran = rnd.nextInt(51);
		cards[i]=ran;
		for(int j=0;j<i;j++){
	 				if(cards[i]==cards[j]){
					    i--;
					    continue cards;
					}
		}
	  }
	 	
	 	
	  //numberは得点
	  number=new int[16];
	  for(int i=0;i<16;i++){
		
		if(cards[i]%13>8){number[i]=10;
		}else{
	 				number[i]=cards[i]%13+1;
		}
		
	  }
	  
    }
	 		
    //プレイヤーの得点
    int pnum1=number[0]+number[1];
    int pnum2=pnum1+10;
    //cpuの得点
    int cnum1=number[2]+number[3];
    int cnum2=cnum1+10;
    
    
    //??
    int hit=1,stand=2;
    int[] stack={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int phcount=4;
    int pp=0,cp=0;
    int win=0;
    int plock=0;
    int c=0;
    
    
    
    MainCanvas(IApplication app) {
	  super();
	  this.setBackground(Graphics.getColorOfName(Graphics.GREEN));
	  
	  
	  this.iapp=app;
	  
	  
	  
	  this.setSoftLabel(Frame.SOFT_KEY_1, "�I��");
	  this.setSoftLabel(Frame.SOFT_KEY_2, "�V�K");
	  
	  //??
	  if((number[0]==1)&&(number[1]==1))pnum2-=9;
	  if((number[2]==1)&&(number[3]==1))cnum2-=9;
	  
	  
	  try {
		img = new Image[53];
		button=new Image[4];
		MediaImage mi0 =MediaManager.getImage("resource:///c01.gif");
		mi0.use();
		img[0] = mi0.getImage();
		MediaImage mi1 =MediaManager.getImage("resource:///c02.gif");
		mi1.use();
		img[1] = mi1.getImage();
		MediaImage mi2 =MediaManager.getImage("resource:///c03.gif");
		mi2.use();
		img[2] = mi2.getImage();
		MediaImage mi3 =MediaManager.getImage("resource:///c04.gif");
		mi3.use();
		img[3] = mi3.getImage();
		MediaImage mi4 =MediaManager.getImage("resource:///c05.gif");
		mi4.use();
		img[4] = mi4.getImage();
		MediaImage mi5 =MediaManager.getImage("resource:///c06.gif");
		mi5.use();
		img[5] = mi5.getImage();
		MediaImage mi6 =MediaManager.getImage("resource:///c07.gif");
		mi6.use();
		img[6] = mi6.getImage();
		MediaImage mi7 =MediaManager.getImage("resource:///c08.gif");
		mi7.use();
		img[7] = mi7.getImage();
		MediaImage mi8 =MediaManager.getImage("resource:///c09.gif");
		mi8.use();
		img[8] = mi8.getImage();
		MediaImage mi9 =MediaManager.getImage("resource:///c10.gif");
		mi9.use();
		img[9] = mi9.getImage();
		MediaImage mi10 =MediaManager.getImage("resource:///c11.gif");
		mi10.use();
		img[10] = mi10.getImage();
		MediaImage mi11 =MediaManager.getImage("resource:///c12.gif");
		mi11.use();
		img[11] = mi11.getImage();
		MediaImage mi12 =MediaManager.getImage("resource:///c13.gif");
		mi12.use();
		img[12] = mi12.getImage();
		MediaImage mi13 =MediaManager.getImage("resource:///d01.gif");
		mi13.use();
		img[13] = mi13.getImage();
		MediaImage mi14 =MediaManager.getImage("resource:///d02.gif");
		mi14.use();
		img[14] = mi14.getImage();
		MediaImage mi15 =MediaManager.getImage("resource:///d03.gif");
		mi15.use();
		img[15] = mi15.getImage();
		MediaImage mi16 =MediaManager.getImage("resource:///d04.gif");
		mi16.use();
		img[16] = mi16.getImage();
		MediaImage mi17 =MediaManager.getImage("resource:///d05.gif");
		mi17.use();
		img[17] = mi17.getImage();
		MediaImage mi18 =MediaManager.getImage("resource:///d06.gif");
		mi18.use();
		img[18] = mi18.getImage();
		MediaImage mi19 =MediaManager.getImage("resource:///d07.gif");
		mi19.use();
		img[19] = mi19.getImage();
		MediaImage mi20 =MediaManager.getImage("resource:///d08.gif");
		mi20.use();
		img[20] = mi20.getImage();
		MediaImage mi21 =MediaManager.getImage("resource:///d09.gif");
		mi21.use();
		img[21] = mi21.getImage();
		MediaImage mi22 =MediaManager.getImage("resource:///d10.gif");
		mi22.use();
		img[22] = mi22.getImage();
		MediaImage mi23 =MediaManager.getImage("resource:///d11.gif");
		mi23.use();
		img[23] = mi23.getImage();
		MediaImage mi24 =MediaManager.getImage("resource:///d12.gif");
		mi24.use();
		img[24] = mi24.getImage();
		MediaImage mi25 =MediaManager.getImage("resource:///d13.gif");
		mi25.use();
		img[25] = mi25.getImage();
		
		MediaImage mi26 =MediaManager.getImage("resource:///h01.gif");
		mi26.use();
		img[26] = mi26.getImage();
		MediaImage mi27 =MediaManager.getImage("resource:///h02.gif");
		mi27.use();
		img[27] = mi27.getImage();
		MediaImage mi28 =MediaManager.getImage("resource:///h03.gif");
		mi28.use();
		img[28] = mi28.getImage();
		MediaImage mi29 =MediaManager.getImage("resource:///h04.gif");
		mi29.use();
		img[29] = mi29.getImage();
		MediaImage mi30 =MediaManager.getImage("resource:///h05.gif");
		mi30.use();
		img[30] = mi30.getImage();
		MediaImage mi31 =MediaManager.getImage("resource:///h06.gif");
		mi31.use();
		img[31] = mi31.getImage();
		MediaImage mi32 =MediaManager.getImage("resource:///h07.gif");
		mi32.use();
		img[32] = mi32.getImage();
		MediaImage mi33 =MediaManager.getImage("resource:///h08.gif");
		mi33.use();
		img[33] = mi33.getImage();
		MediaImage mi34 =MediaManager.getImage("resource:///h09.gif");
		mi34.use();
		img[34] = mi34.getImage();
		MediaImage mi35 =MediaManager.getImage("resource:///h10.gif");
		mi35.use();
		img[35] = mi35.getImage();
		MediaImage mi36 =MediaManager.getImage("resource:///h11.gif");
		mi36.use();
		img[36] = mi36.getImage();
		MediaImage mi37 =MediaManager.getImage("resource:///h12.gif");
		mi37.use();
		img[37] = mi37.getImage();
		MediaImage mi38 =MediaManager.getImage("resource:///h13.gif");
		mi38.use();
		img[38] = mi38.getImage();
		MediaImage mi39 =MediaManager.getImage("resource:///s01.gif");
		mi39.use();
		img[39] = mi39.getImage();
		MediaImage mi40 =MediaManager.getImage("resource:///s02.gif");
		mi40.use();
		img[40] = mi40.getImage();
		MediaImage mi41 =MediaManager.getImage("resource:///s03.gif");
		mi41.use();
		img[41] = mi41.getImage();
		MediaImage mi42 =MediaManager.getImage("resource:///s04.gif");
		mi42.use();
		img[42] = mi42.getImage();
		MediaImage mi43 =MediaManager.getImage("resource:///s05.gif");
		mi43.use();
		img[43] = mi43.getImage();
		MediaImage mi44 =MediaManager.getImage("resource:///s06.gif");
		mi44.use();
		img[44] = mi44.getImage();
		MediaImage mi45 =MediaManager.getImage("resource:///s07.gif");
		mi45.use();
		img[45] = mi45.getImage();
		MediaImage mi46 =MediaManager.getImage("resource:///s08.gif");
		mi46.use();
		img[46] = mi46.getImage();
		MediaImage mi47 =MediaManager.getImage("resource:///s09.gif");
		mi47.use();
		img[47] = mi47.getImage();
		MediaImage mi48 =MediaManager.getImage("resource:///s10.gif");
		mi48.use();
		img[48] = mi48.getImage();
		MediaImage mi49 =MediaManager.getImage("resource:///s11.gif");
		mi49.use();
		img[49] = mi49.getImage();
		MediaImage mi50 =MediaManager.getImage("resource:///s12.gif");
		mi50.use();
		img[50] = mi50.getImage();
		MediaImage mi51 =MediaManager.getImage("resource:///s13.gif");
		mi51.use();
		img[51] = mi51.getImage();
		MediaImage mi52 =MediaManager.getImage("resource:///z02.gif");
		mi52.use();
		img[52] = mi52.getImage();
		MediaImage mi53 =MediaManager.getImage("resource:///hit.jpg");
		mi53.use();
		button[0] = mi53.getImage();
		MediaImage mi54 =MediaManager.getImage("resource:///hitchoosen.jpg");
		mi54.use();
		button[1] = mi54.getImage();
		MediaImage mi55 =MediaManager.getImage("resource:///stand.jpg");
		mi55.use();
		button[2] = mi55.getImage();
		MediaImage mi56 =MediaManager.getImage("resource:///standchoosen.jpg");
		mi56.use();
		button[3] = mi56.getImage();
		
		
		
	  } catch (IllegalArgumentException e) {
		e.printStackTrace();
	  } catch (SecurityException e) {
		e.printStackTrace();
	  } catch (UIException e) {
		e.printStackTrace();
	  } catch (ConnectionException e) {
		e.printStackTrace();
	  }
	  
	  
	  
	  
    }
    
    public void paint(Graphics g) {
	  
	  
	  
	  
	  g.lock();
	  if(phcount==5&&c==0){
		g.clearRect(100, 165, 130, 40);
		c++;
	  }
	  g.drawImage(img[cards[0]],0,160);
   
	  g.drawImage(img[cards[1]],32,160);
	  
	  g.drawImage(img[cards[2]],0,0);
	  
	  g.drawImage(img[52],32,0);
	  
	  g.drawImage(button[hit], 150,80);
	  g.drawImage(button[stand], 150,120);
	  
	  
	  
	  
	  if(stack[0]==1){
		g.drawImage(img[cards[3]], 32,0);
		
	  }else if(stack[1]==1){
		
		g.drawImage(img[cards[4]], 64, 160);
		
	  }else if(stack[2]==1){
		g.drawImage(img[cards[4]], 64, 160);
		g.drawImage(img[cards[5]], 96, 160);
		
	  }else if(stack[3]==1){
		
		g.drawImage(img[cards[4]], 64, 160);
		g.drawImage(img[cards[5]], 96, 160);
		g.drawImage(img[cards[6]], 128, 160);
		
	  }else if(stack[4]==1){
		
		g.drawImage(img[cards[4]], 64, 160);
		g.drawImage(img[cards[5]], 96, 160);
		g.drawImage(img[cards[6]], 128, 160);
		g.drawImage(img[cards[7]], 160, 160);
		
	  }else if(stack[5]==1){
		
		g.drawImage(img[cards[4]], 64, 160);
		g.drawImage(img[cards[5]], 96, 160);
		g.drawImage(img[cards[6]], 128, 160);
		g.drawImage(img[cards[7]], 160, 160);
		g.drawImage(img[cards[8]], 192, 160);
		
	  }else if(stack[6]==1){
		
		g.drawImage(img[cards[4]], 64, 160);
		g.drawImage(img[cards[5]], 96, 160);
		g.drawImage(img[cards[6]], 128, 160);
		g.drawImage(img[cards[7]], 160, 160);
		g.drawImage(img[cards[8]], 192, 160);
		g.drawImage(img[cards[9]], 224, 160);
		
	  }
	  
	  if(stack[7]==1){
		g.drawImage(img[cards[10]], 64, 0);
		
	  }else if(stack[8]==1){
		g.drawImage(img[cards[10]], 64, 0);
		g.drawImage(img[cards[11]], 96, 0);
		
	  }else if(stack[9]==1){
		g.drawImage(img[cards[10]], 64, 0);
		g.drawImage(img[cards[11]], 96, 0);
		g.drawImage(img[cards[12]], 128, 0);
		
	  }else if(stack[10]==1){
		g.drawImage(img[cards[10]], 64, 0);
		g.drawImage(img[cards[11]], 96, 0);
		g.drawImage(img[cards[12]], 128, 0);
		g.drawImage(img[cards[13]], 160, 0);
		
	  }else if(stack[11]==1){
		g.drawImage(img[cards[10]], 64, 0);
		g.drawImage(img[cards[11]], 96, 0);
		g.drawImage(img[cards[12]], 128, 0);
		g.drawImage(img[cards[13]], 160, 0);
		g.drawImage(img[cards[14]], 192, 0);
		
		
	  }else if(stack[12]==1){
		g.drawImage(img[cards[10]], 64, 0);
		g.drawImage(img[cards[11]], 96, 0);
		g.drawImage(img[cards[12]], 128, 0);
		g.drawImage(img[cards[13]], 160, 0);
		g.drawImage(img[cards[14]], 192, 0);
		g.drawImage(img[cards[15]], 224, 0);
	  }
	  
	  if(win==1){
		g.setColor(Graphics.getColorOfName(Graphics.RED));
		g.setFont(Font.getFont(Font.SIZE_MEDIUM));
		g.drawString("You Win�I�I�I", 0, 120);
	  }else if(win==-1){
		g.setFont(Font.getFont(Font.SIZE_MEDIUM));
		g.setColor(Graphics.getColorOfName(Graphics.BLUE));
		
		g.drawString("You Lose�E�E�E", 0, 120);
	  }else if(win==-100){
		g.setFont(Font.getFont(Font.SIZE_MEDIUM));
		g.drawString("Draw", 0, 120);
	  }
	  
	  String pnum1s=Integer.toString(pnum1);
	  String pnum2s=Integer.toString(pnum2);
	  String cnum1s=Integer.toString(cnum1);
	  String cnum2s=Integer.toString(cnum2);
	  
	  g.clearRect(0, 130, 50, 20);
	  g.clearRect(0, 70, 50, 30);
	  
	  g.setFont(Font.getFont(Font.SIZE_TINY));
	  g.setColor(Graphics.getColorOfName(Graphics.BLACK));
	  g.drawString(pnum1s, 0, 140);
	  if(((number[0]==1)||(number[1]==1))&&(pnum2<22))
		g.drawString("/"+pnum2s, 10, 140);
	  
	  if(stack[0]==1){
		g.drawString(cnum1s, 0, 90);
		if(((number[2]==1)||(number[3]==1))&&(cnum2<22))
		    g.drawString("/"+cnum2s, 10, 90);
	  }
	  
	  if(phcount==4){
		g.drawString("���E���E�Q�E�W�ňړ��A", 100, 180);
		g.drawString("����E�T�őI��", 100, 200);
	  }
	  
	  if((number[0]+number[1]==11)&&((number[0]==1)||(number[1]==1))){
		g.setColor(Graphics.getColorOfName(Graphics.SILVER));
		g.setFont(Font.getFont(Font.SIZE_LARGE));
		g.drawString("Blackjack!", 90, 230);
		cturn();
	  }
	  
	  
	  g.unlock(true);
	  
	  
    }
    
    public void processEvent(int type, int param) {
	  super.processEvent(type, param);
	  switch(type){
		case Display.KEY_PRESSED_EVENT:
		    switch(param){
			  case Display.KEY_SOFT1:
				iapp.terminate();
				break;
			  case Display.KEY_SOFT2:
				iapp.start();
				break;
			  case Display.KEY_UP:
				move();
				break;
			  case Display.KEY_DOWN:
				move();
				break;
			  case Display.KEY_SELECT:
				if(hit==1&&win==0&&plock==0){
				    hit();
				    pjudge();
				}else if(win==0){
				    plock++;
				    cturn();
				}break;
			  case Display.KEY_5:
				if(hit==1&&win==0&&plock==0){
				    hit();
				    pjudge();
				}else if(win==0){
				    plock++;
				    cturn();
				    
				    
				}break;
			  case Display.KEY_2:
				move();
				break;
			  case Display.KEY_8:
				move();
				break;
				
				
				
		    }
	  }
    }
    
    
    private void cturn() {
	  stack[0]=1;
	  int i=10;
	  for(;(cnum2<17)&&((number[2]==1)||(number[3]==1));i++){
		cnum1+=number[i];
		cnum2+=number[i];
		stack[i-3]=1;
		if((i!=10)) stack[i-4]=0;
		
		this.repaint();
	  }
	  
	  for(;((number[2]!=1)&&(number[3]!=1)&&(cnum1<15))||((cnum2>21)&&(cnum1<17));i++){
		cnum1+=number[i];
		cnum2+=number[i];
		stack[i-3]=1;
		if((i!=10)) stack[i-4]=0;
		this.repaint();
		
	  }
	  
	  judge();
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    private void judge() {
	  if((number[0]+number[1]==11)&&((number[0]==1)||(number[1]==1))){   //p��BJ�̂Ƃ�p��2�|�C���g
		pp+=2;
	  }
	  
	  if((number[2]+number[3]==11)&&((number[2]==1)||(number[3]==1))){   //c��BJ�̎��E�E�E
		cp+=2;
	  }else if(cnum1>21)cp-=100;                               //c��21�𒴂����Ƃ��E�E�E
	  
	  if(((cnum2<21)&&((number[2]==1)||(number[3]==1)))){  //cnum2���K�p�����Ƃ�
		if((pnum2<21)&&(pnum2<cnum2)&&((number[0]==1)||(number[1]==1))){pp--;
		}else if((pnum2<21)&&(pnum2>cnum2)&&((number[0]==1)||(number[1]==1))){pp++;
		}else if((pnum2>21)&&(pnum1<cnum2)){pp--;
		}else if((pnum2>21)&&(pnum1>cnum2)){pp++;
		}else if((pnum2<21)&&(pnum2==cnum2)&&((number[0]==1)||(number[1]==1))){
		    
		}else if((pnum2>21)&&(pnum1==cnum2)){
		    
		}
	  }else if(cnum2>21){                                   //cnum1���K�p�����Ƃ�
		if((pnum2<21)&&(pnum2<cnum1)&&((number[0]==1)||(number[1]==1))){pp--;
		}else if((pnum2<21)&&(pnum2>cnum1)&&((number[0]==1)||(number[1]==1))){pp++;
		}else if((pnum2>21)&&(pnum1<cnum1)){pp--;
		}else if((pnum2>21)&&(pnum1>cnum1)){pp++;
		}else if((pnum2<21)&&(pnum2==cnum1)&&((number[0]==1)||(number[1]==1))){
		    
		}else if((pnum2>21)&&(pnum1==cnum1)){
		    
		}
		
	  }
	  
	  if(pp==cp){
		win-=100;
	  }else if(pp>cp){
		win++;
	  }else if(pp<cp)win--;
	  
	  this.repaint();
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    
    
    private void pjudge() {
	  if(pnum1>21){
		LOSE();
		
	  }
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    private void LOSE() {
	  win--;
	  this.repaint();
	  
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    public void hit() {
	  if(phcount<10){
		pnum1+=number[phcount];
		pnum2+=number[phcount];
		
		stack[phcount-3]=1;
		stack[phcount-4]=0;
		phcount+=1;
		this.repaint();
	  }
	  
	  
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    public void move() {
	  if(hit==1){
		hit--;
	  }else{
		hit++;
	  }
	  
	  if(stand==3){
		stand--;
	  }else{
		stand++;
	  }
	  
	  this.repaint();
	  // TODO �����������ꂽ���\�b�h�E�X�^�u
	  
    }
    
    
}

