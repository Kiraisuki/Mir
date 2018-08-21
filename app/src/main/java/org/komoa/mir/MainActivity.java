package org.komoa.mir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.hardware.ConsumerIrManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private ImageButton powerButton, modeButton, timerButton, speedButton, upButton, downButton, beepButton;
    private TextView textviewError;
    private boolean hasBlaster = true;
    private ConsumerIrManager irPort;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the IR handler
        irPort = getSystemService(ConsumerIrManager.class);

        //Get the error message label
        textviewError = findViewById(R.id.textviewError);

        //Check if the device has an IR blaster and error if not
        if(!irPort.hasIrEmitter())
        {
            textviewError.setText("Your device lacks an IR Transmitter!\nThis app will not work!");
            hasBlaster = false;
        }

        //Set up buttons and codes if device has blaster
        if(hasBlaster)
        {
            //Get the power button and set its code
            powerButton = findViewById(R.id.buttonPower);

            powerButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.powerCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.powerCodeFreq) * IrCodes.powerCode[i];
                    }

                    irPort.transmit(IrCodes.powerCodeFreq, code);
                }
            });

            //Get the mode button and set its code
            modeButton = findViewById(R.id.buttonMode);

            modeButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.modeCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.modeCodeFreq) * IrCodes.modeCode[i];
                    }

                    irPort.transmit(IrCodes.modeCodeFreq, code);
                }
            });

            //Get the speed button and set its code
            speedButton = findViewById(R.id.buttonSpeed);

            speedButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.speedCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.speedCodeFreq) * IrCodes.speedCode[i];
                    }

                    irPort.transmit(IrCodes.speedCodeFreq, code);
                }
            });

            //Get the speed button and set its code
            upButton = findViewById(R.id.buttonUp);

            upButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.upCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.upCodeFreq) * IrCodes.upCode[i];
                    }

                    irPort.transmit(IrCodes.upCodeFreq, code);
                }
            });

            //Get the speed button and set its code
            downButton = findViewById(R.id.buttonDown);

            downButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.downCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.downCodeFreq) * IrCodes.downCode[i];
                    }

                    irPort.transmit(IrCodes.downCodeFreq, code);
                }
            });

            //Get the speed button and set its code
            timerButton = findViewById(R.id.buttonTimer);

            timerButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.timerCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.timerCodeFreq) * IrCodes.timerCode[i];
                    }

                    irPort.transmit(IrCodes.timerCodeFreq, code);
                }
            });

            //Get the speed button and set its code
            beepButton = findViewById(R.id.buttonBeep);

            beepButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int code[] = new int[IrCodes.beepCode.length];

                    for(int i = 0; i < code.length; i++)
                    {
                        code[i] = (1000000 / IrCodes.beepCodeFreq) * IrCodes.beepCode[i];
                    }

                    irPort.transmit(IrCodes.beepCodeFreq, code);
                }
            });
        }
    }
}
