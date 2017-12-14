/*
 [The "BSD licence"]
 Copyright (c) 2017 Daniel Cortes Pichardo
 All rights reserved.
 
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.
 
 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** A kukulkan grammar 1.0 for ANTLR v4.
 *  
 *  @autor: Daniel Cortes Pichardo 
 *
 *  Grammar used in the kukulkan-core generator
 *
 */
grammar kukulkan;

/**
 * Domain Model Rule
 */
domainModel
:
	entities += entity+
	| settings += option
;

/** 
 * Entity Rule
 *  
 */
entity
:
	'entity' name = ID
	(
		'(' tableName = ID ')'
	)?
	(
		'{'
		(
			fields += entityField
			(
				','? fields += entityField
			)*
		)? '}'
	)?
;

/** 
 * Entity Field Rule
 *  
 */
entityField
:
	id = ID type = fieldType
;

/** 
 * Field Type Rule
 *  
 */
fieldType
:
	stringFieldType
	| numericFieldType
	| booleanFieldType
	| dateFieldType
	| blobFieldType
	| entityType
;

/** 
 * Entity Type Rule
 *  
 */
entityType
:
	entity
;

/** 
 * String Field Type Rule
 *  
 */
stringFieldType
:
	name = stringType constraints += stringValidators*
;

/** 
 * String Type Rule
 *  
 */
stringType
:
	'String'
;

/** 
 * Numeric Field Type Rule
 *  
 */
numericFieldType
:
	name = numericTypes constraints += numericValidators*
;

/** 
 * Numeric Types Rule
 *  
 */
numericTypes
:
	INTEGER
	| LONG
	| BIG_DECIMAL
	| FLOAT
	| DOUBLE
;

/** 
 * INTEGER Token
 *  
 */
INTEGER
:
	'Integer'
;

/** 
 * LONG Token
 *  
 */
LONG
:
	'Long'
;

/** 
 * BIG_DECIMAL Token
 *  
 */
BIG_DECIMAL
:
	'BigDecimal'
;

/** 
 * FLOAT Token
 *  
 */
FLOAT
:
	'Float'
;

/** 
 * DOUBLE Token
 *  
 */
DOUBLE
:
	'Double'
;

/** 
 * Boolean Field Type Token
 *  
 */
booleanFieldType
:
	name= BOOLEAN_TYPE required=requiredValidator*
;

/** 
 * BOOLEAN_TYPE Token
 *  
 */
BOOLEAN_TYPE
:
	'Boolean'
;

/** 
 * Date Field Type Rule
 *  
 */
dateFieldType
:
	type = dateTypes required = requiredValidator?
;

/** 
 * Date Types Rule
 *  
 */
dateTypes
:
	DATE
	| LOCAL_DATE
	| ZONED_DATETIME
	| INSTANT
;

/** 
 * DATE Token
 *  
 */
 
DATE
:
	'Date'
;

/** 
 * LOCAL_DATE Token
 *  
 */
LOCAL_DATE
:
	'LocalDate'
;

/** 
 * ZONED_DATETIME Token
 *  
 */
ZONED_DATETIME
:
	'ZonedDateTime'
;

/** 
 * INSTANT Token
 *  
 */
INSTANT
:
	'Instant'
;

/** 
 * Blob Field Type Rule
 *  
 */
blobFieldType
:
	name = blobTypes constraints += blobValidators*
;

/** 
 * Blob Types Rule
 *  
 */
blobTypes
:
	BLOB
	| ANY_BLOB
	| IMAGE_BLOB
	| TEXT_BLOB
;

/** 
 * BLOB Token
 *  
 */
BLOB
:
	'Blob'
;

/** 
 * ANY_BLOB Token
 *  
 */
ANY_BLOB
:
	'AnyBlob'
;

/** 
 * IMAGE_BLOB Token
 *  
 */
IMAGE_BLOB
:
	'ImageBlob'
;

/** 
 * TEXT_BLOB Token
 *  
 */
TEXT_BLOB
:
	'TextBlob'
;

/* =========================================================================
 * VALIDATOR
 * ========================================================================= */
stringValidators
:
	required = requiredValidator
	| minLenght = minLengthValidator
	| maxLenght = maxLengthValidator
	| pattern = patternValidator
;

numericValidators
:
	required = requiredValidator
	| minValue = minValidator
	| maxValue = maxValidator
;

blobValidators
:
	required = requiredValidator
	| minBytesValue = minBytesValidator
	| maxBytesValue = maxBytesValidator
;

requiredValidator
:
	'required'
;

minLengthValidator
:
	'minlength' '(' NUMERIC_VALUE ')'
;

maxLengthValidator
:
	'maxlength' '(' NUMERIC_VALUE ')'
;

patternValidator
:
	'pattern' '(' PATTERN_VALUE ')'
;

minValidator
:
	'min' '(' NUMERIC_VALUE ')'
;

maxValidator
:
	'max' '(' NUMERIC_VALUE ')'
;

minBytesValidator
:
	'minbytes' '(' NUMERIC_VALUE ')'
;

maxBytesValidator
:
	'maxbytes' '(' value = NUMERIC_VALUE ')'
;

cardinality
:
	ONE_TO_MANY
	| MANY_TO_ONE
	| ONE_TO_ONE
	| MANY_TO_MANY
;

/* =========================================================================
 * OPTION 
 * ========================================================================= */
option
:
	setting = optionSetting
;

optionSetting
:
	dtoOption
;
/* =========================================================================
 * DTO OPTION 
 * ========================================================================= */
dtoOption
:
	'dto'?
;

dtoType
:
	'mapstruct'
;

WS
:
	[ \t\r\n\u000C]+ -> skip
;

COMMENT
:
	'/*' .*? '*/' -> channel ( HIDDEN )
;

LINE_COMMENT
:
	'//' ~[\r\n]* -> channel ( HIDDEN )
;

NUMERIC_VALUE
:
	[0-9]+
;

PATTERN_VALUE
:
	'"' .*? '"'
;

ID
:
	[a-zA-Z$_]*
;

JavaLetterOrDigit
:
	[a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F

	| // covers all characters above 0x7F which are not a surrogate
	~[\u0000-\u007F\uD800-\uDBFF]
	| // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
	[\uD800-\uDBFF] [\uDC00-\uDFFF]
;

ONE_TO_MANY
:
	'OneToMany'
;

MANY_TO_ONE
:
	'ManyToOne'
;

ONE_TO_ONE
:
	'OneToOne'
;

MANY_TO_MANY
:
	'ManyToMany'
;

