/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

//file:noinspection GrMethodMayBeStatic
package techreborn.test.machine

import net.minecraft.item.Items
import net.minecraft.test.GameTest
import techreborn.init.TRContent
import techreborn.test.TRGameTest
import techreborn.test.TRTestContext

class GrinderTest extends TRGameTest {
    @GameTest(templateName = "fabric-gametest-api-v1:empty", tickLimit = 150)
    def testGrind2OCs(TRTestContext context) {
        /**
         * Test that grinder with 2 overclocker upgrades grinds coal into coal dust in 116 ticks
         */
        context.poweredMachine(TRContent.Machine.GRINDER) {
            input(Items.COAL)

            withUpgrades(TRContent.Upgrades.OVERCLOCKER, 2)

            expectOutput(TRContent.Dusts.COAL, 116)
        }
    }
}
