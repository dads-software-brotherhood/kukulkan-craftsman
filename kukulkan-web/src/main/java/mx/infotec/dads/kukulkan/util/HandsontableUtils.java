/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 Roberto Villarejo Martínez
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

package mx.infotec.dads.kukulkan.util;

import org.springframework.cache.annotation.Cacheable;

import mx.infotec.dads.kukulkan.tables.handsontable.BuildStrategy;
import mx.infotec.dads.kukulkan.tables.handsontable.Handsontable;
import mx.infotec.dads.kukulkan.tables.handsontable.HandsontableFactory;

/**
 * Handsontable Utils
 * @author Roberto Villarejo Martínez
 *
 */
public class HandsontableUtils {

    /**
     * Cache wrapper method for HandsontableFactory
     * @param clazz
     * @return
     */
    @Cacheable
    public static <T> Handsontable<T> getHandsontable(Class<T> clazz) {
        return HandsontableFactory.createHandsontable(clazz);
    }

    /**
     * Cache wrapper method for HandsontableFactory
     * @param clazz
     * @param strategy
     * @return
     */
    @Cacheable
    public static <T> Handsontable<T> getHandsontable(Class<T> clazz, BuildStrategy strategy) {
        return HandsontableFactory.getHandsontable(clazz, strategy);
    }

}
