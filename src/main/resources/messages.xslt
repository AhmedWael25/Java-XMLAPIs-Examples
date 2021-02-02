<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <body>
                <h1>My Messages</h1>
                <table border="3">
                    <tr >
                        <th>From</th>
                        <th>To </th>
                        <th>Body</th>
                    </tr>

                    <xsl:for-each select="//message">
                        <xsl:sort select="from"/>
                            <tr>
                                <td>
                                    <xsl:value-of select="from"/>
                                </td>
                                <td>
                                    <xsl:value-of select="to"/>
                                </td>
                                <td>
                                    <xsl:value-of select="body"/>
                                </td>
                            </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
