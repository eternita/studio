/*
 * Copyright (c) 2013-2014, Neuro4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neuro4j.studio.core.diagram.edit.shapes.anchors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ArrowLocator;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.RoutingListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.neuro4j.studio.core.diagram.providers.SelectedConnectionProvider;

public class MyPolylineConnection extends Polyline
        implements Connection, AnchorListener {
    private ConnectionAnchor startAnchor;
    private ConnectionAnchor endAnchor;
    private ConnectionRouter connectionRouter;
    private RotatableDecoration startArrow;
    private RotatableDecoration endArrow;

    public MyPolylineConnection()
    {
        this.connectionRouter = ConnectionRouter.NULL;

        setLayoutManager(new DelegatingLayout());
        addPoint(new Point(0, 0));
        addPoint(new Point(100, 100));
        setBackgroundColor(ColorConstants.blue);
        setLineWidth(2);

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent arg0) {

            }

            @Override
            public void mouseHover(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                if (SelectedConnectionProvider.getInstance().isAvailableForInsert())
                {
                    SelectedConnectionProvider.getInstance().setEvent(null);
                    setForegroundColor(ColorConstants.gray);
                }

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                if (SelectedConnectionProvider.getInstance().isAvailableForInsert())
                {
                    setForegroundColor(ColorConstants.red);
                    SelectedConnectionProvider.getInstance().setEvent(arg0);
                }

            }

            @Override
            public void mouseDragged(MouseEvent arg0) {

            }
        });

        // setLineStyle(1);
    }

    public void addNotify()
    {
        super.addNotify();
        hookSourceAnchor();
        hookTargetAnchor();
    }

    public void addRoutingListener(RoutingListener listener)
    {
        if ((this.connectionRouter instanceof RoutingNotifier)) {
            RoutingNotifier notifier = (RoutingNotifier) this.connectionRouter;
            notifier.listeners.add(listener);
        } else {
            this.connectionRouter = new RoutingNotifier(this.connectionRouter, listener);
        }
    }

    public void anchorMoved(ConnectionAnchor anchor)
    {
        revalidate();
    }

    public Rectangle getBounds()
    {
        if (this.bounds == null) {
            super.getBounds();
            for (int i = 0; i < getChildren().size(); i++) {
                IFigure child = (IFigure) getChildren().get(i);
                this.bounds.union(child.getBounds());
            }
        }
        return this.bounds;
    }

    public ConnectionRouter getConnectionRouter()
    {
        if ((this.connectionRouter instanceof RoutingNotifier))
            return ((RoutingNotifier) this.connectionRouter).realRouter;
        return this.connectionRouter;
    }

    public Object getRoutingConstraint()
    {
        if (getConnectionRouter() != null) {
            return getConnectionRouter().getConstraint(this);
        }
        return null;
    }

    public ConnectionAnchor getSourceAnchor()
    {
        return this.startAnchor;
    }

    protected RotatableDecoration getSourceDecoration()
    {
        return this.startArrow;
    }

    public ConnectionAnchor getTargetAnchor()
    {
        return this.endAnchor;
    }

    protected RotatableDecoration getTargetDecoration()
    {
        return this.endArrow;
    }

    private void hookSourceAnchor() {
        if (getSourceAnchor() != null)
            getSourceAnchor().addAnchorListener(this);
    }

    private void hookTargetAnchor() {
        if (getTargetAnchor() != null)
            getTargetAnchor().addAnchorListener(this);
    }

    public void layout()
    {
        if ((getSourceAnchor() != null) && (getTargetAnchor() != null)) {
            this.connectionRouter.route(this);
        }
        Rectangle oldBounds = this.bounds;
        super.layout();
        this.bounds = null;

        if (!getBounds().contains(oldBounds)) {
            getParent().translateToParent(oldBounds);
            getUpdateManager().addDirtyRegion(getParent(), oldBounds);
        }

        repaint();
        fireFigureMoved();
    }

    public void removeNotify()
    {
        unhookSourceAnchor();
        unhookTargetAnchor();
        this.connectionRouter.remove(this);
        super.removeNotify();
    }

    public void removeRoutingListener(RoutingListener listener)
    {
        if ((this.connectionRouter instanceof RoutingNotifier)) {
            RoutingNotifier notifier = (RoutingNotifier) this.connectionRouter;
            notifier.listeners.remove(listener);
            if (notifier.listeners.isEmpty())
                this.connectionRouter = notifier.realRouter;
        }
    }

    public void revalidate()
    {
        super.revalidate();
        this.connectionRouter.invalidate(this);
    }

    public void setConnectionRouter(ConnectionRouter cr)
    {
        if (cr == null)
            cr = ConnectionRouter.NULL;
        ConnectionRouter oldRouter = getConnectionRouter();
        if (oldRouter != cr) {
            this.connectionRouter.remove(this);
            if ((this.connectionRouter instanceof RoutingNotifier))
                ((RoutingNotifier) this.connectionRouter).realRouter = cr;
            else {

                this.connectionRouter = cr;

            }
            // this.connectionRouter = cr;
            firePropertyChange("connectionRouter",
                    oldRouter, cr);
            revalidate();
        }
    }

    public void setRoutingConstraint(Object cons)
    {
        if (this.connectionRouter != null)
            this.connectionRouter.setConstraint(this, cons);
        revalidate();
    }

    public void setSourceAnchor(ConnectionAnchor anchor)
    {
        if (anchor == this.startAnchor)
            return;
        unhookSourceAnchor();

        this.startAnchor = anchor;
        if (getParent() != null)
            hookSourceAnchor();
        revalidate();
    }

    public void setSourceDecoration(RotatableDecoration dec)
    {
        if (this.startArrow == dec)
            return;
        if (this.startArrow != null)
            remove(this.startArrow);
        this.startArrow = dec;
        if (this.startArrow != null)
            add(this.startArrow, new ArrowLocator(this, 2));
    }

    public void setTargetAnchor(ConnectionAnchor anchor)
    {
        if (anchor == this.endAnchor)
            return;
        unhookTargetAnchor();

        this.endAnchor = anchor;
        if (getParent() != null)
            hookTargetAnchor();
        revalidate();
    }

    public void setTargetDecoration(RotatableDecoration dec)
    {
        if (this.endArrow == dec)
            return;
        if (this.endArrow != null)
            remove(this.endArrow);
        this.endArrow = dec;
        if (this.endArrow != null)
            add(this.endArrow, new ArrowLocator(this, 3));
    }

    private void unhookSourceAnchor() {
        if (getSourceAnchor() != null)
            getSourceAnchor().removeAnchorListener(this);
    }

    private void unhookTargetAnchor() {
        if (getTargetAnchor() != null)
            getTargetAnchor().removeAnchorListener(this);
    }

    final class RoutingNotifier
            implements ConnectionRouter
    {
        ConnectionRouter realRouter;
        List listeners = new ArrayList(1);

        RoutingNotifier(ConnectionRouter router, RoutingListener listener) {
            this.realRouter = router;
            this.listeners.add(listener);
        }

        public Object getConstraint(Connection connection) {
            return this.realRouter.getConstraint(connection);
        }

        public void invalidate(Connection connection) {
            for (int i = 0; i < this.listeners.size(); i++) {
                ((RoutingListener) this.listeners.get(i)).invalidate(connection);
            }
            this.realRouter.invalidate(connection);
        }

        public void route(Connection connection) {
            boolean consumed = false;
            for (int i = 0; i < this.listeners.size(); i++)
            {
                consumed = consumed | ((RoutingListener) this.listeners.get(i))
                        .route(connection);
            }
            if (!consumed) {
                this.realRouter.route(connection);
            }
            for (int i = 0; i < this.listeners.size(); i++)
                ((RoutingListener) this.listeners.get(i)).postRoute(connection);
        }

        public void remove(Connection connection) {
            for (int i = 0; i < this.listeners.size(); i++)
                ((RoutingListener) this.listeners.get(i)).remove(connection);
            this.realRouter.remove(connection);
        }

        public void setConstraint(Connection connection, Object constraint) {
            for (int i = 0; i < this.listeners.size(); i++)
                ((RoutingListener) this.listeners.get(i)).setConstraint(connection,
                        constraint);
            this.realRouter.setConstraint(connection, constraint);
        }
    }

}