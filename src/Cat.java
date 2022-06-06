import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.Random;


public class Cat extends JFrame implements WindowListener {
    JLabel label;
    URL battlepass = getClass().getClassLoader().getResource("battle pass.wav");
    URL carmen = getClass().getClassLoader().getResource("AAAAAAUGH.wav");
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("cat.png"));
    ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ezgif.com-gif-maker.gif"));
    Random random = new Random();
    int x = 0;
    int y = 500;
    public void PlaySoundLoop(URL battlepass){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(battlepass));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){

        }
    }

    public void PlaySoundOnce(URL url){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(battlepass));
            clip.start();
        }catch(Exception e){

        }
    }
    public Cat() throws InterruptedException {
        this.setSize(640, 578);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.setIconImage(icon.getImage());
        this.setTitle("Cat safe version");
        PlaySoundLoop(battlepass);
        label = new JLabel();
        label.setIcon(image);
        label.setVisible(true);
        this.add(label);
        this.setVisible(true);
        while(true){ //this is the code that is in charge of moving the cat around the screen, is pretty useless since there is an easier way to do it, but it works lol.
            if(x > 1400){
                x = 0;
            }
            x++;
            Thread.sleep(1);
            y--;
            Thread.sleep(5);
            if(x == 1400){
                while(x>=0){
                    x--;
                    y--;
                    Thread.sleep(5);
                    System.out.println("x" + x);
                    System.out.println("y " + y);
                    this.setLocation(x,y);
                    if(y == 0){
                        while(y<=600){
                            y++;
                            Thread.sleep(5);
                            x--;
                            this.setLocation(x,y);
                        }

                    }
                }
            }
            if(y == 0){
                while(y<=600){
                    y++;
                    x++;
                    this.setLocation(x,y);
                    Thread.sleep(5);
                    if(x==1340){
                        while(x<=0){
                            x--;
                            y--;
                            this.setLocation(x,y);
                        }

                    }
                    System.out.println(" y "+ y);
                    System.out.println("x" + x);
                }
            }
            this.setLocation(x,y);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        PlaySoundOnce(carmen); //This is made so u cant close the program and the code below is really useless but i'm leaving it just becase.
        JOptionPane.showMessageDialog(null, "YOU CANT ESCAPE FROM THE CAT");
        for(int i = 0 ; i < 10 ; i++){

            x = random.nextInt(0,1300);
            y = random.nextInt(0,600);
            this.setLocation(x,y);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
