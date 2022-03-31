package net.selfish.utils;

import javax.swing.JComponent;

public class Animations {
    
    private static Animations instance;
    
    public static Animations getInstance(){
        if(instance==null){
            instance=new Animations();
        }
        return instance;
    }
    
    public void setComponentYUp(final int start,final int stop, final int delay, final int increment, final JComponent jComponent){
        if(jComponent.getY()==start){
            new Thread(){
                @Override
                public void run(){
                    while(jComponent.getY()>stop){
                        for(int i=start;i>=stop;i-=increment){
                            try {
                                Thread.sleep(delay);
                                jComponent.setLocation(jComponent.getX(),i);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    jComponent.setLocation(jComponent.getX(), stop);
                }
            }.start();
        }
    }
    
    public void setComponentYDown(final int start,final int stop, final int delay, final int increment, final JComponent jComponent){
        if(jComponent.getY()==start){
            new Thread(){
                @Override
                public void run(){
                    while(jComponent.getY()<=start){
                        for(int i=start;i<=stop;i+=increment){
                            try {
                                Thread.sleep(delay);
                                jComponent.setLocation(jComponent.getX(),i);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    jComponent.setLocation(jComponent.getX(), stop);
                }
            }.start();
        }
    }
    
    public void setComponentXLeft(final int start, final int stop, final int delay, final int increment, final JComponent jComponent){
        if (jComponent.getX() == start) {
            new Thread(){
                @Override
                public void run(){
                    try{
                        for (int i = start; i >= stop; i -= increment) {
                            Thread.sleep(delay);
                            jComponent.setLocation(i, jComponent.getY());
                        }
                        jComponent.setLocation(stop, jComponent.getY());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
    
    public void setComponentXRight(final int start, final int stop, final int delay, final int increment, final JComponent jComponent){
        if (jComponent.getX() == start) {
            new Thread(){
                @Override
                public void run(){
                    try {
                        for (int i = start; i <= stop; i += increment) {
                            Thread.sleep(delay);
                            jComponent.setLocation(i, jComponent.getY());
                        }
                        jComponent.setLocation(stop, jComponent.getY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
