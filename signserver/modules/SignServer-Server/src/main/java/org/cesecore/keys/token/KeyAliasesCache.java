/*************************************************************************
 *                                                                       *
 *  EJBCA Community: The OpenSource Certificate Authority                *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.cesecore.keys.token;

import java.security.PublicKey;

import org.signserver.server.cesecore.internal.CommonCacheBase;

/**
 * Cache for Key aliases (used in Azure Crypto Token, but is generic). Caches a public key, with alias as key
 * 
 * @version $Id$
 */
public class KeyAliasesCache extends CommonCacheBase<PublicKey> {

    long lastUpdate = 0L;

    @Override
    public PublicKey getEntry(final Integer id) {
        if (id == null) {
            return null;
        }
        return super.getEntry(id);
    }

    public void updateCacheTimeStamp() {
        this.lastUpdate = System.currentTimeMillis();
    }

    @Override
    protected long getCacheTime() {
        return 30000; // Cache key aliases for 30 seconds
    }

    @Override
    protected long getMaxCacheLifeTime() {
        return 30000; // Cache key aliases for 30 seconds
    }

}
