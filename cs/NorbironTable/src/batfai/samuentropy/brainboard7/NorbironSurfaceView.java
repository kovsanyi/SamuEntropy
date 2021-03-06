/*
 * NorbironSurfaceView.java
 *
 * Norbiron Game
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. Bátfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthető illetve módosítható a
 * Free Software Foundation által kiadott GNU General Public License
 * dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi
 * változata szerint.
 *
 * Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz,
 * de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA
 * VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve.
 * További részleteket a GNU General Public License tartalmaz.
 *
 * A felhasználónak a programmal együtt meg kell kapnia a GNU General
 * Public License egy példányát; ha mégsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */
package batfai.samuentropy.brainboard7;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.util.Log;

class Nodes {

    private android.graphics.Bitmap boardPic;
    private android.graphics.Bitmap neuronSprite;
    private android.graphics.Bitmap nandIronProcCover;
    public static android.graphics.Bitmap buildproci;
    private NeuronBox[] neuronBox;

    public Nodes(android.view.SurfaceView surfaceView) {
        int resId = surfaceView.getResources().getIdentifier("pcb550i", "drawable", "batfai.samuentropy.brainboard7");

        boardPic = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        boardPic = android.graphics.Bitmap.createScaledBitmap(boardPic, 300, 300, false);

        resId = surfaceView.getResources().getIdentifier("neuronsprite", "drawable", "batfai.samuentropy.brainboard7");
        neuronSprite = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        neuronSprite = android.graphics.Bitmap.createScaledBitmap(neuronSprite, 64 * 2 * 14, 62, false);

        neuronBox = new NeuronBox[7];

        resId = surfaceView.getResources().getIdentifier("nandironproci", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[0] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 100, nandIronProcCover, 100, 100);

        resId = surfaceView.getResources().getIdentifier("nandironproci2", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[1] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 350, 100);

        resId = surfaceView.getResources().getIdentifier("matyironproci", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[2] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 600, 100);

        resId = surfaceView.getResources().getIdentifier("matyironproci2", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[3] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 100, nandIronProcCover, 100, 400);

        resId = surfaceView.getResources().getIdentifier("gretironproci", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[4] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 350, 400);

        resId = surfaceView.getResources().getIdentifier("gretironproci2", "drawable", "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[5] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 600, 400);

        resId = surfaceView.getResources().getIdentifier("buildproci", "drawable", "batfai.samuentropy.brainboard7");
        buildproci = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        /*
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 84, 98, false);
        neuronBox[6] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 0+27+7, 0+27+7);
        neuronBox[6].setType(-1);
        */
    }

    public android.graphics.Bitmap getBoardPic() {
        return boardPic;
    }

    public NeuronBox get(int i) {
        return neuronBox[i];
    }

    public int getSize() {
        return neuronBox.length;
    }
}

/**
 *
 * @author nbatfai
 */
public class NorbironSurfaceView extends android.view.SurfaceView implements Runnable {
    //############++++############
    private static final int NODES_START = 0;
    private static Database database;
    private static final String SELECT_TABLE_NODES = "SELECT * FROM nodes";
    private static final String CREATE_TABLE_NODES = "CREATE TABLE nodes(id INTEGER PRIMARY KEY, type INTEGER, pos_x INTEGER, pos_y INTEGER)";
    private static final String DROP_TABLE_NODES = "DROP TABLE IF EXISTS nodes";
    private boolean loading = false;
    private boolean deleted = false;
    private boolean deleting = false;
    private long pressed = 0;
    //############----############

    private float startsx = 0;
    private float startsy = 0;
    private float width = 2048;
    private float height = 2048;

    protected float swidth;
    protected float sheight;

    protected float fromsx;
    protected float fromsy;

    protected float boardx = 0;
    protected float boardy = 0;

    private Nodes nodes;
    private static java.util.List<NeuronBox> nodeBoxes = new java.util.ArrayList<NeuronBox>();

    protected NeuronBox selNb = null;

    private android.view.SurfaceHolder surfaceHolder;
    private android.view.ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;

    private boolean running = true;

    private android.content.Context context;

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public NorbironSurfaceView(android.content.Context context) {
        super(context);
        cinit(context);
    }

    public NorbironSurfaceView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        cinit(context);
    }

    public NorbironSurfaceView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        cinit(context);
    }

    @Override
    protected void onSizeChanged(int newx, int newy, int x, int y) {
        super.onSizeChanged(newx, newy, x, y);

        width = newx;
        height = newy;

        swidth = width / 2 - nodes.getBoardPic().getWidth() / 2;
        sheight = height / 2 - nodes.getBoardPic().getHeight() / 2;
    }

    //############++++############
    private void saveNodes(){
        database.getWritableDatabase().execSQL(DROP_TABLE_NODES);
        Log.d("SAVE_NODES", DROP_TABLE_NODES);
        database.getWritableDatabase().execSQL(CREATE_TABLE_NODES);
        Log.d("SAVE_NODES", CREATE_TABLE_NODES);
        for(int i=NODES_START; i<nodeBoxes.size(); i++){
            if(nodeBoxes.get(i).getType() != -1 ){
                String INSERT_INTO_NODES = String.format("INSERT INTO nodes(type, pos_x, pos_y) VALUES (%s, %s, %s)",
                        Integer.valueOf(nodeBoxes.get(i).getType()).toString(),
                        Integer.valueOf(nodeBoxes.get(i).getX()).toString(),
                        Integer.valueOf(nodeBoxes.get(i).getY()).toString());
                database.getWritableDatabase().execSQL(INSERT_INTO_NODES);
                Log.d("SAVE_NODES", INSERT_INTO_NODES);
            }
        }
    }
    //############----############

    private void cinit(android.content.Context context) {
        this.context = context;
        nodes = new Nodes(this);

        /*
        if (nodeBoxes.size() == 0) {
            nodeBoxes.add((NeuronBox) nodes.get(6).clone());
        }
        */

        android.content.Intent intent = ((NeuronGameActivity) context).getIntent();
        android.os.Bundle bundle = intent.getExtras();

        if (bundle != null) {
            int i = bundle.getInt("selectedNode");

            android.util.Log.w("alma", "s" + i);

            //nodeBoxes.add((NeuronBox) nodes.get(i).clone());
            //############++++############
            String INSERT_INTO_NODES = String.format("INSERT INTO nodes(type, pos_x, pos_y) VALUES (%s, %s, %s)",
                    Integer.valueOf(nodes.get(i).getType()).toString(),
                    Integer.valueOf(nodes.get(i).getX()).toString(),
                    Integer.valueOf(nodes.get(i).getY()).toString());
            database.getWritableDatabase().execSQL(INSERT_INTO_NODES);
            Log.d("ADD_NODE",INSERT_INTO_NODES);
            NeuronBox node = (NeuronBox) nodes.get(i).clone();
            node.setType(i);
            nodeBoxes.add(node);
            //############----############
        } else{
            //############++++############
            database = new Database(context);
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    if(loading){
                        Log.d("DO_IN_BACKGROUND", "FAILED TO LOAD NODES. LOADING IN PROGRESS!");
                        return null;
                    }
                    Log.d("DO_IN_BACKGROUND", "STARTED");
                    loading = true;
                    int type, pos_x, pos_y;
                    try {
                        database.getResult(SELECT_TABLE_NODES);
                        Log.d("DO_IN_BACKGROUND", SELECT_TABLE_NODES);
                    } catch(SQLiteException e){
                        database.getWritableDatabase().execSQL(CREATE_TABLE_NODES);
                        Log.d("DO_IN_BACKGROUND", CREATE_TABLE_NODES);
                        database.getResult(SELECT_TABLE_NODES);
                        Log.d("DO_IN_BACKGROUND", SELECT_TABLE_NODES);
                    }
                    if(database.getLastResult().moveToFirst()){
                        do{
                            type = database.getLastResult().getInt(database.getLastResult().getColumnIndex("type"));
                            pos_x = database.getLastResult().getInt(database.getLastResult().getColumnIndex("pos_x"));
                            pos_y = database.getLastResult().getInt(database.getLastResult().getColumnIndex("pos_y"));
                            NeuronBox node = (NeuronBox) nodes.get(type).clone();
                            node.setType(type);
                            node.setXY((float) pos_x, (float) pos_y);
                            nodeBoxes.add(node);
                            Log.d("DO_IN_BACKGROUND", "NODE ADDED TO SURFACE("
                                    + Integer.valueOf(type).toString() + ", "
                                    + Integer.valueOf(pos_x).toString() + ", "
                                    + Integer.valueOf(pos_y).toString() + ")");
                        } while(database.getLastResult().moveToNext());
                    }
                    loading = false;
                    Log.d("DO_IN_BACKGROUND", "FINISHED");
                    return null;
                }
            }.execute();
            //############----############
        }

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceEvents(this));

        scaleGestureDetector = new android.view.ScaleGestureDetector(context, new ScaleAdapter(this));

    }

    @Override
    public void onDraw(android.graphics.Canvas canvas) {

        if (surfaceHolder.getSurface().isValid()) {

            canvas.save();
            canvas.scale(scaleFactor, scaleFactor);

            canvas.drawColor(android.graphics.Color.BLACK);

            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    canvas.drawBitmap(nodes.getBoardPic(), -startsx + boardx + i * 300, -startsy + boardy + j * 300, null);
                }
            }

            if(!deleting){
                for (NeuronBox nb : nodeBoxes) {
                    //############++++############
                    if(nb.getType() != -1){
                        nb.draw(-startsx, -startsy, canvas);
                    }
                    //############----############
                }
            } else {
                nodeBoxes.clear();
                saveNodes();
                deleting = false;
            }
            //############++++############
            canvas.drawBitmap(nodes.buildproci, null, new android.graphics.Rect(10, 10, 124, 138), null);
            //############----############
            canvas.restore();
        }
    }

    public void repaint() {
        android.graphics.Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                onDraw(canvas);
            }

        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public float d(float x1, float x2, float y1, float y2) {
        return (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
    }

    protected NeuronBox nearestNeuronBox(float x, float y) {

        NeuronBox r = null;
        float max = 10000, m;

        for (NeuronBox nb : nodeBoxes) {
            if ((m = d(nb.getX() + nb.getWidth() / 2, nb.getY() + nb.getHeight() / 2, x, y)) < max) {
                max = m;
                r = nb;
            }
        }
        return r;
    }

    public void newNode() {
        android.content.Intent i = new android.content.Intent(context, NodeActivity.class);
        context.startActivity(i);
    }

    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);

        float x = event.getX() / scaleFactor;
        float y = event.getY() / scaleFactor;

        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

            //############++++############
            pressed = System.currentTimeMillis();
            //############----############

            fromsx = x;
            fromsy = y;

            NeuronBox nb = nearestNeuronBox(x + startsx, y + startsy);
            if (nb != null) {

                if (nb.getType() == -1) {
                    if (!nb.getSelected() && !loading) {
                        newNode();
                    }
                } else{
                    nb.setCover(!nb.getCover());
                    nb.setSelected(!nb.getSelected());
                }
                selNb = nb;

            } else {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_POINTER_DOWN) {

            if (selNb != null) {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_CANCEL) {

        } else if (event.getAction() == android.view.MotionEvent.ACTION_MOVE) {
            //############++++############
            if (event.getX()<124+10 && event.getY()<138+10 && !loading){
                if(System.currentTimeMillis() - pressed >= 500 && !deleted){
                    deleted = true;
                    deleting = true;
                    return true;
                }
            }
            //############----############

            if (selNb != null && selNb.getType() != -1) {
                selNb.setXY(selNb.getX() - (fromsx - x), selNb.getY() - (fromsy - y));

                fromsx = x;
                fromsy = y;

            } else if (Math.abs(fromsx - x) + Math.abs(fromsy - y) > 25) {
                startsx += (fromsx - x);
                startsy += (fromsy - y);

                fromsx = x;
                fromsy = y;
            }

            repaint();

        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
            //############++++############
            if (event.getX()<124+10 && event.getY()<138+10 && !loading){
                if(!deleted){
                    newNode();
                    return true;
                } else{
                    deleted = false;
                }
            } else{
                if(selNb != null){
                    saveNodes();
                    return true;
                }
            }
            //############----############
        }

        return true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        //############++++############
        long now = System.currentTimeMillis();
        long newNow;
        running = true;
        while(running){
            if((newNow = System.currentTimeMillis()) - now > 100){
                for(NeuronBox nb:nodeBoxes){
                    nb.step();
                }
                now=newNow;
                repaint();
            }
        }
        //############----############

        /*
        float spritex = 0;
        while (running) {
            if ((newnow = System.currentTimeMillis()) - now > 100) {
                for (NeuronBox nb : nodeBoxes) {
                    nb.step();
                }
                repaint();
                now = newnow;
            }
        }
        */
    }
}
