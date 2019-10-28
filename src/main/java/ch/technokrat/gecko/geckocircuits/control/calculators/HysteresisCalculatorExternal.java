/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  GeckoCIRCUITS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.technokrat.gecko.geckocircuits.control.calculators;

public final class HysteresisCalculatorExternal extends AbstractControlCalculatable {

    public HysteresisCalculatorExternal() {
        super(2, 1);        
    }

    @Override
    public void berechneYOUT(final double deltaT) {
        final double hValue = _inputSignal[1][0];
        if (_inputSignal[0][0] > +hValue) {
            _outputSignal[0][0] = 1;
        } else if (_inputSignal[0][0] < -hValue) {
            _outputSignal[0][0] = -1;
        } else if (_inputSignal[0][0] == hValue) {
            _outputSignal[0][0] = Math.signum(_inputSignal[0][0]);
        }
    }
}