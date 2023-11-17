package frc.robot.CONFIG;

public final class CONFIG {
    public static class CANCoderOffsets{
      public static final double topLeftOffset = -348.837890625; // 11.865234375 + 180;
      public static final double topRightOffset = -24.345703125; // -25.83984275 + 180;
      public static final double bottomLeftOffset = -101.14453125 + 180; // -209.091796875;// 153.0175781 - 16 - 180;
      public static final double bottomRightOffset = -353.05664062; // 7.294921875 - 180;
    }
    public static class CANID {
        // drive motors
        public static final int topDriveLeftCANID = 5; // 5
        public static final int topDriveRightCANID = 7;
        public static final int bottomDriveLeftCANID = 9;
        public static final int bottomDriveRightCANID = 3; // 3
    
        // turn motors
        public static final int topTurnLeftCANID = 6; // 6
        public static final int topTurnRightCANID = 8;
        public static final int bottomTurnLeftCANID = 1;
        public static final int bottomTurnRightCANID = 4; // 4
    
        // cancoder
        public static final int topTurnLeftCANCoderCANID = 18; // 18
        public static final int topTurnRightCANCoderCANID = 17;
        public static final int bottomTurnLeftCANCoderCANID = 15; // BAD
        public static final int bottomTurnRightCANCoderCANID = 16; // 16
    
        // intakes
        public static final int topLeftIntakeCANID = 57;
        public static final int topRightIntakeCANID = 62;
        public static final int bottomLeftIntakeCANID = 60;
        public static final int bottomRightIntakeCANID = 61;
        public static final int toprollersCANID = 59;
        public static final int bottomrollersCANID = 58;
    
        // revh ph
    
        public static final int revpdhCANID = 23; // MUST MAKE SURE IT IS ON RIO NOT CANIVORE
    
        public static final int pigeonCANID = 30;
      }
    
}
