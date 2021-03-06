/*
 * Copyright 2016 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.yangutils.datamodel;

import org.onosproject.yangutils.datamodel.exceptions.DataModelException;
import org.onosproject.yangutils.parser.Parsable;
import org.onosproject.yangutils.utils.YangConstructType;

/*
 *  Reference:RFC 6020.
 *  The "namespace" statement defines the XML namespace that all
 *  identifiers defined by the module are qualified by, with the
 *  exception of data node identifiers defined inside a grouping.
 *  The argument to the "namespace" statement is the URI of the
 *  namespace.
 */

/**
 * Name space to be used for the XML data tree.
 */
public class YangNameSpace implements Parsable {

    private String uri;

    /**
     * Default constructor.
     */
    public YangNameSpace() {
    }

    /**
     * Get the name space URI.
     *
     * @return the URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * Set the name space URI.
     *
     * @param uri the URI to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Returns the type of the parsed data.
     *
     * @return returns NAMESPACE_DATA
     */
    @Override
    public YangConstructType getYangConstructType() {
        return YangConstructType.NAMESPACE_DATA;
    }

    /**
     * Validate the data on entering the corresponding parse tree node.
     *
     * @throws DataModelException a violation of data model rules
     */
    @Override
    public void validateDataOnEntry() throws DataModelException {
        // TODO auto-generated method stub, to be implemented by parser

    }

    /**
     * Validate the data on exiting the corresponding parse tree node.
     *
     * @throws DataModelException a violation of data model rules
     */
    @Override
    public void validateDataOnExit() throws DataModelException {
        // TODO auto-generated method stub, to be implemented by parser

    }
}
