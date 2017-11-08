import lejos.nxt.*;

public class Main {

	public static void main(String[] args) {
		
		LightSensor lightLeft = new LightSensor(SensorPort.S1);
		LightSensor lightRight = new LightSensor(SensorPort.S2);
		LightSensor lightSide = new LightSensor(SensorPort.S3);
		
		
		while(true) {
			}	
		
	}

}



/* OLD BRICX CC CODE

#define NEAR 9
#define SPEED 40
#define BLACK 35
#define LS_INFLUENCE_FAC 1

int normalize(float val, float min, float max) {
if(max - min < 1.0) return SPEED;

return ((val - min) / (max - min)) * 100.0;
}

task main()
{
 SetSensorLight(IN_1);   // Middle
 SetSensorLight(IN_2);   // Right
 SetSensorLight(IN_3);   // Left
 SetSensorUltrasonic(IN_4);// UltraSonicSensor

 int minLightValue2 = 1000;
 int maxLightValue2 = -1;
 int minLightValue1 = 1000;
 int maxLightValue1 = -1;
 int threshold_lightsensor1 = 50;
 int threshold_lightsensor2 = 50;

 while(true){
 //Update Min/Max Light Values
             if(SENSOR_1 < minLightValue1) minLightValue1 = SENSOR_1;
             if(SENSOR_1 > maxLightValue1) maxLightValue1 = SENSOR_1;
             if(SENSOR_2 < minLightValue2) minLightValue2 = SENSOR_2;
             if(SENSOR_2 > maxLightValue2) maxLightValue2 = SENSOR_2;
             threshold_lightsensor1 = (maxLightValue1 + minLightValue1) / 2;
             threshold_lightsensor2 = (maxLightValue2 + minLightValue2) / 2;

             int sensorDiff1 = (threshold_lightsensor1 - SENSOR_1)*LS_INFLUENCE_FAC;
             int sensorDiff2 = (threshold_lightsensor2 - SENSOR_2)*LS_INFLUENCE_FAC;

             
             int aSpeed = SPEED + sensorDiff1;
             int bSpeed = SPEED + sensorDiff2;

             if(aSpeed < 0) aSpeed = 0;
             if(bSpeed < 0) bSpeed = 0;
             //OnFwd(OUT_A, -normalize(SENSOR_2, minLightValue2, maxLightValue2));
             //OnFwd(OUT_B, -normalize(SENSOR_1, minLightValue1, maxLightValue1));

             bSpeed = 20 + ((SENSOR_2 - minLightValue2) * SPEED) / (maxLightValue2 - minLightValue2);
             aSpeed = 20 + ((SENSOR_1 - minLightValue1) * SPEED) / (maxLightValue1 - minLightValue1);

             OnFwd(OUT_A, - aSpeed);
             OnFwd(OUT_B, - bSpeed);

      TextOut(1,60, "L Sensor1: "+NumToStr(SENSOR_1) + "       ");
      TextOut(1,50, "L Sensor2: "+NumToStr(SENSOR_2) + "       ");
      TextOut(1,40, "SpeedA: "+NumToStr(aSpeed) + "       ");
      TextOut(1,30, "SpeedB: "+NumToStr(bSpeed) + "       ");

      if(SENSOR_3 < BLACK){
          TextOut(1,1, "LEFT LightSensor Black");
          OnFwd(OUT_A, -SPEED);
          OnFwd(OUT_B, -SPEED);
          Wait(300);
      }
      else{
          TextOut(1,1, "                       ");
      }

      if(SENSOR_2 < BLACK){
          TextOut(1,20, "RIGHT LightSensor Black");
      }
      else{
          TextOut(1,20, "                       ");
      }

      TextOut(1,45, NumToStr(SensorUS(IN_4)) + "            ");

      //while(SensorUS(IN_4)>NEAR);


      if(SensorUS(IN_4)<=NEAR){
           TextOut(1,30, "Have a can  ");
      }
      else{
           TextOut(1,30, "                       ");
      }



 }
}

void forwardUntilCrossing()
{


}

void crossing(int direction){

 if(direction == 1 ){
  // Turn to the RIGHT
  RotateMotorEx(OUT_AB, 75, 360, 50, true, true);
 }

 if(direction == 0){
  // Go on straight forward
 }

 if(direction == 2){
  // Turn to the LEFT
  RotateMotorEx(OUT_AB, 75, -360, 50, true, true);
 }
}

*/