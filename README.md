# Silver_Arrow-Dungeon_Demo

## Synopsis
This here is a true demo of gameplay that I want to make in the near future. This demo is of a mini-dungeon with so far only two puzzles and five of eleven rooms complete. The dungeon takes inspiration from the classic Legend of Zelda where each room is the full screen and you move it each room through doors. You must complete the puzzles to unlock the doors that are blocking your progress. The puzzles are switches with the first one needing you to hit them in the right order and the second you have to match them all to the right color. To hit the switches, you must shoot them with our "arrow" by using the cursor to aim. The only harmful part of the dungeon is a room with saw blades that are moving back and forth. Dispite only making five rooms, I am proud of what I've made. I was able to write all the code I need, with help in some parts. I made the graphics with graphics obtained from OpenGameArt.org and the health was created by Emilee DeFriez, who is a friend of my wife. I plan to finish the dungeon in the near future with more puzzles and hazards up ahead. More will come.

## Motivation
The motivation behind this is that I wanted to actually make a demo that I can really have people to play. I've made two "demos" before this but they were more of preparation for this demo. That's one reason, the next is that I also wanted game making pratice because I want to make game as a career in the future and hopefully it's the near future. Those are the main motivations that caused me to create this. I hope to continue to improve on the skills that I've learned to create a full-fledged game in the future. I guess that my last movivation but that's my plan in the future.

## How To Play
You'll need the following files to play: Character, HealthBars, Object, Rooms, and RoomsGraphics. Character as the class for the playable character, HealthBars and RoomsGraphics as the game's graphics, Object as the hit boxs for the graphics, and Rooms run the demo and has the rooms of the dungeon.

## Code Example
There is some much code that I am proud of making so here are examples of my favorite codes.
```
public void moveSawBladeA() {
        if (this.viewSawBladeA.getY() >= 800) {
            southA = false;
        }
        else if (this.viewSawBladeA.getY() <= 100) {
            southA = true;
        }
        
        if (this.viewSawBladeA.getY() < 800 && southA) {
            this.viewSawBladeA.setY(this.viewSawBladeA.getY() + speed);
            this.sawBladeAHitbox.setCenterY(this.sawBladeAHitbox.getCenterY() + speed);
            this.viewSawBladeA.setRotate(this.viewSawBladeA.getRotate() + speed);
        }
        else {
            this.viewSawBladeA.setY(this.viewSawBladeA.getY() - speed);
            this.sawBladeAHitbox.setCenterY(this.sawBladeAHitbox.getCenterY() - speed);
            this.viewSawBladeA.setRotate(this.viewSawBladeA.getRotate() + speed);
        }
    }
```
```
Timeline checkSawBladeA = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (room4.isCollidingSawBladeA()) {
                if (room4ToRoom5) {
                    room4.getCharacter().resetPosition(room4.getXWest(), room4.getYWest());
                }
                else {
                    room4.getCharacter().resetPosition(room4.getXSouth(), room4.getYSouth());
                }
                
                if (room4.getHealth() == full) {
                    room4.replaceHealth(two);
                }
                else if (room4.getHealth() == two) {
                    room4.replaceHealth(one);
                }
                else if (room4.getHealth() == one) {
                    room4.replaceHealth(empty);
                }
            }
        }));
```
The first one is how the saw blades move, that method is in the class for Room 4. The second one is how the collision and damage is done. The timeline is used as a listener for when the saw blade hits the character.
```
if (!isRoom2PuzzleComplete) {
                if (room2.getSwitch1Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch1() != switchOn) {
                        room2.replaceSwitch1(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 1;
                        room2PuzzleIndex++;
                    }
                }
                else if (room2.getSwitch2Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch2() != switchOn) {
                        room2.replaceSwitch2(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 2;
                        room2PuzzleIndex++;
                    }
                }
                else if (room2.getSwitch3Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch3() != switchOn) {
                        room2.replaceSwitch3(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 3;
                        room2PuzzleIndex++;
                    }
                }
                
                if (room2PuzzleIndex == 3) {
                    if (room2PuzzleAnswer[0] == room2PuzzleInput[0] && room2PuzzleAnswer[1] == room2PuzzleInput[1] && 
                            room2PuzzleAnswer[2] == room2PuzzleInput[2]) {
                        isRoom2PuzzleComplete = true;
                    }
                    else {
                        room2PuzzleInput = new int[3];
                        room2PuzzleIndex = 0;
                        room2.replaceSwitch1(switchOff);
                        room2.replaceSwitch2(switchOff);
                        room2.replaceSwitch3(switchOff);
                    }
                    
                }
```
This is how the puzzle in Room 2 is solved. I have an array with the answer in it, an array that is filled when the switchs are hit, and an index that moves with each input. There is a boolean that acts as a flag to check if the puzzle as been complete or not. It starts out false and becomes true when it's complete.
```
public boolean isCollidingBottom(double x, double y, double width, double height) {
        if (getHitboxX() + getHitboxWidth() > x && getHitboxX() < x + width && 
                getHitboxY() + getHitboxHeight() > y && getHitboxY() - speed < y + height) {
            return true;
        }
        else {
            return false;
        }
    }
```
```
public boolean isCollidingNorthWall() {
        return this.character.isCollidingBottom(this.northWall.getRectX(), this.northWall.getRectY(), + 
                this.northWall.getRectWidth(), this.northWall.getRectHeight());
    }
```
This is how the collision checks are done. The CharacterPane class as collision detection for colliding with an object from each side. This one is an example for colliding with the bottom of an object. Each room's class as collision method for the side's that the object can be collidied into.
