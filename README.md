# carrito_rojo_java_con_interfaz_graficaSwing :. 
## 🏎️ Juego del Carrito Rojo en Java (Swing)

<img width="260" height="120" alt="image" src="https://github.com/user-attachments/assets/bdc48074-b864-4610-9d34-be192e2cd4e3" />  

## Solución completa, profesional y lista para ejecutar en IntelliJ IDEA, para el juego del carrito rojo en Java con interfaz gráfica (Swing).
## Es un minijuego donde el usuario controla un carro rojo moviéndose en pantalla mediante las flechas del teclado. Incluye animación, colisiones con bordes y estructura limpia.

## ✔️ Características del Juego

* Interfaz gráfica en Swing

* Carrito rojo dibujado en pantalla

* Movimiento con teclas:

* Flecha arriba

* Flecha abajo

* Flecha izquierda

* Flecha derecha

* Control de velocidad

* Límite de pantalla (no se sale del área de juego)

* Redibujado con Timer para animación fluida

* Totalmente listo para ejecutar en IntelliJ IDEA

* No requiere librerías externas ni base de datos

## 📌 Estructura del Proyecto

* Proyecto Java simple con un único archivo:

* RedCarGame.java

## ✅ Código Completo (copiar y pegar) .
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RedCarGame extends JFrame {

    public RedCarGame() {
        setTitle("Juego del Carrito Rojo");
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

    public GamePanel() {
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);

        // Timer para refrescar la pantalla
        Timer timer = new Timer(25, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar pista simple
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(100, 50, 600, 450);

        // Líneas de carretera
        g.setColor(Color.WHITE);
        for (int i = 60; i < 500; i += 40) {
            g.fillRect(390, i, 20, 20);
        }

        // Dibujar carrito rojo
        g.setColor(Color.RED);
        g.fillRoundRect(carX, carY, CAR_WIDTH, CAR_HEIGHT, 10, 10);

        // Detalles del carro
        g.setColor(Color.BLACK);
        g.fillOval(carX + 5, carY + CAR_HEIGHT - 5, 15, 15);
        g.fillOval(carX + CAR_WIDTH - 20, carY + CAR_HEIGHT - 5, 15, 15);

        // Título
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(Color.BLUE);
        g.drawString("Juego del Carrito Rojo - Usa las flechas para moverte", 180, 25);
    }

    // ----------- MOVIMIENTO -----------
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
    public void keyTyped(KeyEvent e) {}
}
```
## ▶️ Cómo Ejecutarlo en IntelliJ IDEA

* Abrir IntelliJ

* Crear un nuevo proyecto Java

* Dentro de src, crear un archivo:

* RedCarGame.java

* Ejecutar main

* El juego abrirá una ventana lista para jugar

## 🔧 Mejoras Opcionales

* Si deseas evolucionarlo, se pueden agregar:

* Sistema de puntos y marcador

* Obstáculos

* Choques y Game Over

* Sonido

* Fondo animado

* Persistencia en Oracle 19c

* Arquitectura por capas

* Exportación como .jar ejecutable .

© 2025 Giovanny Alejandro Tapiero Cataño & chatGpt .  
Todos los derechos reservados.

Este proyecto y su código fuente están protegidos por la legislación internacional de derechos de autor.  
No se permite su reproducción total o parcial, distribución, modificación o uso con fines comerciales
sin autorización expresa del autor.
