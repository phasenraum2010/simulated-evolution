package org.woehlke.computer.kurzweil.commons.widgets;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.application.ComputerKurzweilContext;
import org.woehlke.computer.kurzweil.commons.gui.GuiComponent;
import org.woehlke.computer.kurzweil.commons.layouts.FlowLayoutCenter;

import javax.swing.*;


@Log4j2
@ToString
@EqualsAndHashCode(callSuper=true)
public class PanelCopyright extends JPanel implements GuiComponent {

    public PanelCopyright(ComputerKurzweilContext ctx) {
        this.setLayout(new FlowLayoutCenter());
        String copyright = ctx.getProperties().getAllinone().getView().getCopyright();
        this.add(new JLabel(copyright));
    }

   // @Override
    public void showMe() {
        this.setVisible(true);
    }

}
