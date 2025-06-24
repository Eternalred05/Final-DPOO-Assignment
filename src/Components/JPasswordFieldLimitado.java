package Components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPasswordFieldLimitado extends  JPasswordField {

	public JPasswordFieldLimitado() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField) e.getSource();
				if (text.getText().length() == limit)
					e.consume();
			}

		});

	}

	private int limit = -1;

	public int getLimite() {
		return this.limit;
	}
	public void setLimit(int limit) {
		if (limit >= -1)
			this.limit = limit;
	}


}
