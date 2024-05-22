package console;

import java.util.Timer;
import java.util.TimerTask;

public class GameConsole {
    private final Brand brand;
    private final String model;
    private final String serial;
    private final Gamepad firstGamepad;
    private final Gamepad secondGamepad;
    private boolean isOn;
    private Game activeGame;
    private int waitingCounter;

    public GameConsole(Brand brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.model = "";
        this.firstGamepad = new Gamepad(brand, serial, 1);
        this.secondGamepad = new Gamepad(brand, serial, 2);
        this.isOn = false;
        this.waitingCounter = 0;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void loadGame(Game game) {
        activeGame = game;
        System.out.println("Game " + game.getName() + " is loading...");
    }

    public void playGame() {
        if (activeGame == null) {
            System.out.println("No game loaded.");
            return;
        }

        System.out.println("Playing " + activeGame.getName() + "...");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                firstGamepad.decreaseCharge(10);
                secondGamepad.decreaseCharge(10);

                checkStatus();
            }
        }, 0, 1000);
    }

    private void checkStatus() {
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            waitingCounter++;
            System.out.println("Connect a gamepad.");

            if (waitingCounter >= 5) {
                turnOff();
                throw new GameConsoleInactiveException("Game console is turning off due to inactivity.");
            }
        } else {
            waitingCounter = 0;
        }
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Game console is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Game console is turned off.");
    }

    public class Gamepad {
        private final Brand brand;
        private final String consoleSerial;
        private final int connectedNumber;
        private boolean isOn;
        private double chargeLevel;

        public Gamepad(Brand brand, String consoleSerial, int connectedNumber) {
            this.brand = brand;
            this.consoleSerial = consoleSerial;
            this.connectedNumber = connectedNumber;
            this.isOn = false;
            this.chargeLevel = 100.0;
        }

        public Brand getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public boolean isOn() {
            return isOn;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public void setOn(boolean on) {
            isOn = on;
        }

        public void decreaseCharge(double amount) {
            if (chargeLevel > 0) {
                chargeLevel -= amount;
                if (chargeLevel <= 0) {
                    turnOff();
                }
            }
        }
    }
}
