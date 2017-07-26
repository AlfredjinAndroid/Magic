package com.jinxudong.magic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyBitmapViewAnother extends View {
	private int width;// ���ø�
	private int height;// ���ø�
	private Paint mPaint;
	// ����һ��Bitmap
	private Bitmap bitmap;
	// ������Bitmap�Ļ���
	private Canvas bitmapCanvas;
	private Paint mPaintCover;
	private Paint mPaintRect;
	// ����һ����������Bitmap
	private Bitmap mBitmapBackground;
	private Matrix matrix;
	private Path mPath;

	public MyBitmapViewAnother(Context context) {
		super(context);
	}

	public MyBitmapViewAnother(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();// Bitmap�Ļ���
		// ���ñ���
		switch (ImageUtil.tempData) {
		case 1:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.hxj);
			break;
		case 2:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.hxq);
			break;

		case 3:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.hxk);
			break;
		case 4:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.fkj);
			break;
		case 5:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.fkq);
			break;
		case 6:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.fkk);
			break;
		case 7:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.htj);
			break;
		case 8:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.htq);
			break;
		case 9:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.htk);
			break;
		case 10:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.mhj);
			break;
		case 11:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.mhq);
			break;
		case 12:
			mBitmapBackground = BitmapFactory.decodeResource(getResources(),
					R.drawable.mhk);
			break;
		default:
			break;
		}
		mPaintCover = new Paint();
		mPaintCover.setAntiAlias(true);
		mPaintCover.setColor(Color.WHITE);
		mPaintCover.setStrokeWidth(100);
		// ����ͼ�λ�Ϸ�ʽ������ʹ��PorterDuff.Mode.XORģʽ����ײ��ص�������Ϊ͸��PorterDuff.Mode.XOR
		PorterDuffXfermode mode = new PorterDuffXfermode(
				android.graphics.PorterDuff.Mode.XOR);
		mPaintCover.setXfermode(mode);
		mPaintCover.setStyle(Paint.Style.STROKE);
		// ���ñ�ˢ����ʽ��Ĭ��ΪBUTT���������ΪROUND(Բ��),SQUARE(����)����Ҫ���������Style����ΪSTROKE����FILL_AND_STROKE
		mPaintCover.setStrokeCap(Paint.Cap.ROUND);
		// ���û��ʵĽ�Ϸ�ʽ
		mPaintCover.setStrokeJoin(Paint.Join.ROUND);

		// �����ɰ�Ļ���
		mPaintRect = new Paint();
		mPaintRect.setAntiAlias(true);
		mPaintRect.setColor(Color.BLACK);

		// ·����¼������Ļ��·����
		mPath = new Path();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
		height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
		setMeasuredDimension(width, height);// ���ÿ�͸�

		// ����һ��Bitmap�����ڻ�ͼ��
		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		bitmapCanvas = new Canvas(bitmap);// �û���Ϊbitmap��

		// ���Ʊ���BitmapBackground��С�ľ���
		matrix = new Matrix();// ����ڹ������г�ʼ������Ҫʹ��reset()����
		matrix.postScale((float) width / mBitmapBackground.getWidth(),
		(float) height / mBitmapBackground.getHeight());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// ��bitmapBackground���ø�View�����ı���
		canvas.drawBitmap(mBitmapBackground, matrix, null);
		// Ȼ�󻭲���ӱ����Ļ��������bitmap��
		canvas.drawBitmap(bitmap, 0, 0, mPaint);
		bitmapCanvas.drawRect(0, 0, width, height, mPaintRect);// bitmap�ϻ���һ���ɰ�
		bitmapCanvas.drawPath(mPath, mPaintCover);// bitmap�ϻ����� ������·��
	}

	// �������ó�ʼֵ��Ϊ�˲������Ļʱ ������ʾ·��
	private float down_x = -100;
	private float down_y = -100;
	private float move_x = -100;
	private float move_y = -100;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// ��õ����Ļʱ������
			down_x = event.getX();
			down_y = event.getY();
			// ��Path�ƶ��������
			mPath.moveTo(down_x, down_y);
			invalidate();// ���»���
			return true;
		case MotionEvent.ACTION_MOVE:
			// �������Ļ���ƶ�������
			move_x = event.getX();
			move_y = event.getY();
			// ���ƶ��Ĺ켣����ֱ��
			mPath.lineTo(move_x, move_y);
			// Ȼ���ƶ�����һ���㡣
			mPath.moveTo(move_x, move_y);
			invalidate();// ���»���
			return true;
		}
		return super.onTouchEvent(event);
	}

}