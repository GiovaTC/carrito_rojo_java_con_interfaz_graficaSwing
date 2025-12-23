import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedCarGame extends JFrame {

    public RedCarGame() {
        setTitle("Juego del carrito rojo");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RedCarGame::new);
    }
}

class GamePanel extends JPanel implements KeyListener {

    private int carX = 350;
    private int carY = 250;
    private final int CAR_WIDTH = 60;
    private final int CAR_HEIGHT = 40;
    private final int SPEED = 10;

    private int score = 0;
    private boolean gameOver = false;

    private final List<Rectangle> obstacles = new ArrayList<>();
    private final Random random = new Random(); 

    public GamePanel() {
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);   
        
        createObstacles();

        // timer principal del juego .
        Timer timer = new Timer(30, e -> gameLoop());
        timer.start();

        // timer del marcador .
        Timer scoreTimer = new Timer(2000, e -> {
            if (!gameOver) score += 10; {}
        });
        scoreTimer.start();
    }

    private void createObstacles() {
        obstacles.clear();
        for (int i = 0; i < 5; i++) {
            int x = 120 + random.nextInt(500);
            int y = 60 + random.nextInt(380);
            obstacles.add(new Rectangle(x, y, 50, 30)); 
        }
    }

    private void gameLoop() {
        if (!gameOver) moveObstacles();
        checkCollision();
        repaint();
    }

    private void checkCollision() {
    }

    private void moveObstacles() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibujar pista simple .
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(100, 50, 600, 450);

        // lineas de carretera .
        g.setColor(Color.WHITE);
        for (int i = 60; i < 500; i += 40) {
            g.fillRect(390, i, 20, 20);
        }

        // dibujar carrito rojo .
        g.setColor(Color.RED);
        g.fillRoundRect(carX, carY, CAR_WIDTH, CAR_HEIGHT, 10, 10);

        // detalles del carro .
        g.setColor(Color.BLACK);
        g.fillOval(carX + 5, carY + CAR_HEIGHT - 5, 15, 15);
        g.fillOval(carX + CAR_WIDTH - 20, carY + CAR_HEIGHT - 5, 15, 15);

        // titulo
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(Color.BLUE);
        g.drawString("Juego del Carrito Rojo - Usa las flechas para moverte", 180, 25);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP -> {
                if (carY - SPEED >= 50) carY -= SPEED;
            }
            case KeyEvent.VK_DOWN -> {
                if (carY + SPEED + 40 <= 500) carY += SPEED;
            }
            case KeyEvent.VK_LEFT -> {
                if (carX - SPEED >= 100) carX -= SPEED;
            }
            case KeyEvent.VK_RIGHT -> {
                if (carX + SPEED + 60 <= 700) carX += SPEED;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
    }
}