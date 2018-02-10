package com.example.student.flappyspaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by student on 08/02/2018.
 */

public class PlayerShip
{
    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;
    private boolean boosting;

    private final int GRAVITY = -12;
    private int maxY;
    private int minY;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    public PlayerShip(Context context, int screenX, int screenY)
    {
        x = 50;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
        boosting = false;

        maxY = screenY - bitmap.getHeight();
        minY = 0;
    }

    public void update()
    {

        if (boosting)
        {
            speed += 2;
        }
        else
        {
            speed -= 5;
        }

        if (speed > MAX_SPEED)
        {
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED)
        {
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        if (y < minY)
        {
            y = minY;
        }

        if (y > maxY)
        {
            y = maxY;
        }
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setBoosting() { boosting = true; }

    public void stopBoosting() { boosting = false; }
}