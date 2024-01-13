;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Class_255_0)
(use IconI)
(use SysWindow)
(use Obj)


(local
	local0
)
(procedure (localproc_0004 param1 param2 param3 &tmp temp0 newEvent temp2 temp3)
	(= temp3
		(+
			(/ (- (param1 nsRight?) (param1 nsLeft?)) 2)
			(param1 nsLeft?)
		)
	)
	(= temp2 param2)
	(return
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							((= newEvent (Event new:)) x: temp3 y: temp2 yourself:)
					)
				)
				(newEvent dispose:)
				(return temp0)
			)
			(newEvent dispose:)
			(if (< param2 param3)
				(= temp2 (+ temp2 4))
			else
				(= temp2 (- temp2 4))
			)
		)
	)
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 4
		modifiers $0000
		signal $0000
		helpStr 0
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		description 0
		owner 0
		script 0
		value 0
	)
	
	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)
	
	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== highlightColor -1) (return))
		(= temp4
			(if (and argc param1) highlightColor else lowlightColor)
		)
		(= temp0 (- nsTop 2))
		(= temp1 (- nsLeft 2))
		(= temp2 (+ nsBottom 1))
		(= temp3 (+ nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph
			grUPDATE_BOX
			(- nsTop 2)
			(- nsLeft 2)
			(+ nsBottom 2)
			(+ nsRight 2)
			1
		)
	)
	
	(method (onMe param1)
		(return (if (super onMe: param1) (not (& signal $0004)) else 0))
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner (= owner theOwner))
		(if (and value (= theOwner gLarry))
			(gGame changeScore: value)
			(= value (= value 0))
		)
		(return self)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc255_4 995 0 description)
			)
		)
	)
)

(class Inv of IconBar
	(properties
		elements 0
		size 0
		height 0
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		port 0
		window 0
		state $0400
		activateHeight 0
		y 0
		normalHeading {Roger is carrying:}
		heading 0
		empty {nothing!}
		curScore {Score: %d out of %d}
		showScore 1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)
	
	(procedure (localproc_0089 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 gInvFirst temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20)
		(= temp0
			(= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))
		)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			((= temp9 (NodeValue gInvFirst)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal?) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal?) $0004))
				)
			else
				(++ temp3)
				(= temp5
					(+
						temp5
						(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
					)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(if (not temp0)
			(proc255_4 995 1 normalHeading empty)
			(return)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3) (= temp16 3))
		(if
		(< (* temp16 (= local0 (/ temp0 temp16))) temp0)
			(++ local0)
		)
		(= temp10
			(proc999_3 (+ 4 temp5) (* local0 (+ 4 temp2)))
		)
		(= temp12
			(/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2)
		)
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (gInv window?)
			((gInv window?)
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open:
			)
		)
		(= temp20 local0)
		(if temp0
			(= temp18
				(+
					2
					(if ((gInv window?) respondsTo: #yOffset)
						((gInv window?) yOffset?)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if ((gInv window?) respondsTo: #xOffset)
							((gInv window?) xOffset?)
						else
							0
						)
					)
				)
			)
			(= gInvFirst (gInv first:))
			(while gInvFirst
				(if
					(and
						(not
							(& ((= temp9 (NodeValue gInvFirst)) signal?) $0004)
						)
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal?) $0080))
						(temp9
							nsLeft:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft?) temp6)
							nsBottom: (+ (temp9 nsTop?) temp7)
						)
						(if (-- temp20)
							(= temp17 (+ temp17 temp2))
						else
							(= temp20 local0)
							(= temp18 (+ temp18 temp1))
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft?))
						(= temp18 (temp9 nsTop?))
					)
					(temp9 show:)
					(if (== temp9 param2) (temp9 highlight:))
				)
				(= gInvFirst (gInv next: gInvFirst))
			)
		)
		(= temp17
			(/
				(-
					(- ((gInv window?) right?) ((gInv window?) left?))
					temp5
				)
				2
			)
		)
		(= temp11
			(- ((gInv window?) bottom?) ((gInv window?) top?))
		)
		(= temp18 32767)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			(not ((= temp9 (NodeValue gInvFirst)) isKindOf: InvI))
				(= temp6
					(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(= temp7
					(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(if (not (& (temp9 signal?) $0080))
					(if (== temp18 32767) (= temp18 (- temp11 temp7)))
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft?) temp6))
				(= temp18 (temp9 nsTop?))
				(temp9 signal: (& (temp9 signal?) $fffb) show:)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
	)
	
	
	(method (init)
		(= gInv self)
		(= heading (= heading normalHeading))
	)
	
	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8)
		(while ((= temp1 (Event new:)) type:)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(= temp1 0)
		(while (= temp1 (Event new:))
			(if (& state $0020)
				(= temp8 0)
				(temp1 localize:)
				(if
					(and
						curIcon
						(not (temp1 modifiers:))
						(!= curIcon selectIcon)
						(or
							(== (temp1 type:) evMOUSEBUTTON)
							(and
								(== (temp1 type:) evKEYBOARD)
								(== (temp1 message:) KEY_RETURN)
								(= temp8 1)
							)
							(and (== (temp1 type:) evJOYDOWN) (= temp8 1))
						)
						(or
							(!= curIcon helpIconItem)
							(& (helpIconItem signal:) $0010)
						)
					)
					(temp1 type: $4000 message: (curIcon message:))
				)
				(MapKeyToDir temp1)
				(cond
					((and (== (= temp2 (temp1 type:)) evMOUSEBUTTON) (temp1 modifiers:))
						(self advanceCurIcon:)
						(temp1 claimed: 1)
					)
					(
						(and
							(== temp2 evNULL)
							(= temp0 (self firstTrue: #onMe temp1))
							(!= temp0 highlightedIcon)
						)
						(self highlight: temp0)
					)
					(
						(or
							(== temp2 evMOUSEBUTTON)
							(and (== temp2 evKEYBOARD) (== (temp1 message:) KEY_RETURN))
							(== temp2 evJOYDOWN)
						)
						(if
							(and
								(IsObject highlightedIcon)
								(self select: highlightedIcon (== temp2 evMOUSEBUTTON))
							)
							(cond
								((== highlightedIcon okButton)
									(break)
								)
								((== highlightedIcon helpIconItem)
									(if (!= (highlightedIcon cursor:) -1)
										(gGame
											setCursor: (helpIconItem cursor:)
										)
									)
									(cond
										((& state $0800)
											(self noClickHelp:)
										)
										(helpIconItem
											(helpIconItem
												signal:
													(|
														(helpIconItem signal:)
														$0010
													)
											)
										)
									)
								)
								(else
									(= curIcon highlightedIcon)
									(gGame setCursor: (curIcon cursor:) 1)
								)
							)
						)
					)
					((& temp2 $0040) ; direction
						(switch (temp1 message:)
							(JOY_RIGHT
								(self advance:)
							)
							(JOY_LEFT
								(self retreat:)
							)
							(JOY_UP
								(if
									(and
										highlightedIcon
										(= temp0
											(localproc_0004
												highlightedIcon
												(- (highlightedIcon nsTop:) 1)
												0
											)
										)
									)
									(self highlight: temp0 1)
								else
									(self retreat:)
								)
							)
							(JOY_DOWN
								(if
									(and
										highlightedIcon
										(= temp0
											(localproc_0004
												highlightedIcon
												(+
													(highlightedIcon nsBottom:)
													1
												)
												(window bottom:)
											)
										)
									)
									(self highlight: temp0 1)
								else
									(self advance:)
								)
							)
							(JOY_NULL
								(if (& temp2 evKEYBOARD)
									(self advanceCurIcon:)
								)
							)
						)
					)
					((== temp2 evKEYBOARD)
						(switch (temp1 message:)
							(KEY_TAB
								(self advance:)
							)
							(KEY_SHIFTTAB
								(self retreat:)
							)
						)
					)
					(
						(and
							(== temp2 $4000)
							(= temp0 (self firstTrue: #onMe temp1))
						)
						(cond
							((== (temp1 message:) JOY_DOWNLEFT)
								(if (and temp0 (temp0 helpStr:))
									(if (gWindow respondsTo: #eraseOnly)
										(= temp6 (gWindow eraseOnly:))
										(gWindow eraseOnly: 1)
										(proc255_4 995 0 (temp0 helpStr:)) ; "%s"
										(gWindow eraseOnly: temp6)
									else
										(proc255_4 995 0 (temp0 helpStr:)) ; "%s"
									)
								)
								(helpIconItem
									signal: (& (helpIconItem signal:) $ffef)
								)
								(gGame setCursor: 999)
							)
							((== temp0 okButton)
								(break)
							)
							((not (temp0 isKindOf: InvI))
								(if (self select: temp0 (not temp8))
									(= curIcon temp0)
									(gGame setCursor: (curIcon cursor:) 1)
								)
							)
							(curIcon
								(if (gWindow respondsTo: #eraseOnly)
									(= temp6 (gWindow eraseOnly:))
									(gWindow eraseOnly: 1)
								)
								(if (curIcon isKindOf: InvI)
									(temp0
										doVerb:
											(curIcon message:)
											(self indexOf: curIcon)
									)
								else
									(temp0 doVerb: (temp1 message:))
								)
								(if (gWindow respondsTo: #eraseOnly)
									(gWindow eraseOnly: temp6)
								)
							)
						)
					)
				)
			else
				(break)
			)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(self hide:)
	)
;;;	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8)
;;;		(asm
;;;code_0607:
;;;			pushi    #type
;;;			pushi    0
;;;			pushi    #new
;;;			pushi    0
;;;			class    Event
;;;			send     4
;;;			sat      temp1
;;;			send     4
;;;			bnt      code_0623
;;;			pushi    #dispose
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			jmp      code_0607
;;;code_0623:
;;;			pushi    #dispose
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			ldi      0
;;;			sat      temp1
;;;code_062f:
;;;			pushi    #new
;;;			pushi    0
;;;			class    Event
;;;			send     4
;;;			sat      temp1
;;;			bnt      code_0a69
;;;			pTos     state
;;;			ldi      32
;;;			and     
;;;			bnt      code_0a69
;;;			ldi      0
;;;			sat      temp8
;;;			pushi    #localize
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			pToa     curIcon
;;;			bnt      code_06da
;;;			pushi    #modifiers
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			not     
;;;			bnt      code_06da
;;;			pTos     curIcon
;;;			pToa     selectIcon
;;;			ne?     
;;;			bnt      code_06da
;;;			pushi    #type
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      1
;;;			eq?     
;;;			bt       code_06ad
;;;			pushi    #type
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      4
;;;			eq?     
;;;			bnt      code_0698
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      13
;;;			eq?     
;;;			bnt      code_0698
;;;			ldi      1
;;;			sat      temp8
;;;			bt       code_06ad
;;;code_0698:
;;;			pushi    #type
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      256
;;;			eq?     
;;;			bnt      code_06da
;;;			ldi      1
;;;			sat      temp8
;;;			bnt      code_06da
;;;code_06ad:
;;;			pTos     curIcon
;;;			pToa     helpIconItem
;;;			ne?     
;;;			bt       code_06c2
;;;			pushi    #signal
;;;			pushi    0
;;;			pToa     helpIconItem
;;;			send     4
;;;			push    
;;;			ldi      16
;;;			and     
;;;			bnt      code_06da
;;;code_06c2:
;;;			pushi    #type
;;;			pushi    1
;;;			pushi    16384
;;;			pushi    40
;;;			pushi    1
;;;			pushi    #message
;;;			pushi    0
;;;			pToa     curIcon
;;;			send     4
;;;			push    
;;;			lat      temp1
;;;			send     12
;;;code_06da:
;;;			pushi    1
;;;			lst      temp1
;;;			callk    MapKeyToDir,  2
;;;			pushi    #type
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			sat      temp2
;;;			push    
;;;			ldi      1
;;;			eq?     
;;;			bnt      code_070f
;;;			pushi    #modifiers
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			bnt      code_070f
;;;			pushi    #advanceCurIcon
;;;			pushi    0
;;;			self     4
;;;			pushi    #claimed
;;;			pushi    1
;;;			pushi    1
;;;			lat      temp1
;;;			send     6
;;;			jmp      code_0a5e
;;;code_070f:
;;;			lst      temp2
;;;			ldi      0
;;;			eq?     
;;;			bnt      code_0737
;;;			pushi    #firstTrue
;;;			pushi    2
;;;			pushi    196
;;;			lst      temp1
;;;			self     8
;;;			sat      temp0
;;;			bnt      code_0737
;;;			push    
;;;			pToa     highlightedIcon
;;;			ne?     
;;;			bnt      code_0737
;;;			pushi    #highlight
;;;			pushi    1
;;;			lst      temp0
;;;			self     6
;;;			jmp      code_0a5e
;;;code_0737:
;;;			lst      temp2
;;;			ldi      1
;;;			eq?     
;;;			bt       code_075c
;;;			lst      temp2
;;;			ldi      4
;;;			eq?     
;;;			bnt      code_0753
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      13
;;;			eq?     
;;;			bt       code_075c
;;;code_0753:
;;;			lst      temp2
;;;			ldi      256
;;;			eq?     
;;;			bnt      code_07f4
;;;code_075c:
;;;			pushi    1
;;;			pTos     highlightedIcon
;;;			callk    IsObject,  2
;;;			bnt      code_0a5e
;;;			pushi    168
;;;			pushi    #-info-
;;;			pTos     highlightedIcon
;;;			lst      temp2
;;;			ldi      1
;;;			eq?     
;;;			push    
;;;			self     8
;;;			bnt      code_0a5e
;;;			pTos     highlightedIcon
;;;			pToa     okButton
;;;			eq?     
;;;			bnt      code_0785
;;;			jmp      code_0a69
;;;			jmp      code_0a5e
;;;code_0785:
;;;			pTos     highlightedIcon
;;;			pToa     helpIconItem
;;;			eq?     
;;;			bnt      code_07d9
;;;			pushi    #cursor
;;;			pushi    0
;;;			pToa     highlightedIcon
;;;			send     4
;;;			push    
;;;			ldi      65535
;;;			ne?     
;;;			bnt      code_07ac
;;;			pushi    #setCursor
;;;			pushi    1
;;;			pushi    #cursor
;;;			pushi    0
;;;			pToa     helpIconItem
;;;			send     4
;;;			push    
;;;			lag      gGame
;;;			send     6
;;;code_07ac:
;;;			pTos     state
;;;			ldi      2048
;;;			and     
;;;			bnt      code_07be
;;;			pushi    #noClickHelp
;;;			pushi    0
;;;			self     4
;;;			jmp      code_0a5e
;;;code_07be:
;;;			pToa     helpIconItem
;;;			bnt      code_0a5e
;;;			pushi    17
;;;			pushi    #superClass
;;;			pushi    #signal
;;;			pushi    0
;;;			send     4
;;;			push    
;;;			ldi      16
;;;			or      
;;;			push    
;;;			pToa     helpIconItem
;;;			send     6
;;;			jmp      code_0a5e
;;;code_07d9:
;;;			pToa     highlightedIcon
;;;			aTop     curIcon
;;;			pushi    #setCursor
;;;			pushi    2
;;;			pushi    #cursor
;;;			pushi    0
;;;			pToa     curIcon
;;;			send     4
;;;			push    
;;;			pushi    1
;;;			lag      gGame
;;;			send     8
;;;			jmp      code_0a5e
;;;code_07f4:
;;;			lst      temp2
;;;			ldi      64
;;;			and     
;;;			bnt      code_08b5
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			dup     
;;;			ldi      3
;;;			eq?     
;;;			bnt      code_0815
;;;			pushi    #advance
;;;			pushi    0
;;;			self     4
;;;			jmp      code_08b1
;;;code_0815:
;;;			dup     
;;;			ldi      7
;;;			eq?     
;;;			bnt      code_0825
;;;			pushi    #retreat
;;;			pushi    0
;;;			self     4
;;;			jmp      code_08b1
;;;code_0825:
;;;			dup     
;;;			ldi      1
;;;			eq?     
;;;			bnt      code_085d
;;;			pToa     highlightedIcon
;;;			bnt      code_0854
;;;			pushi    3
;;;			push    
;;;			pushi    #nsTop
;;;			pushi    0
;;;			send     4
;;;			push    
;;;			ldi      1
;;;			sub     
;;;			push    
;;;			pushi    0
;;;			call     localproc_0004,  6
;;;			sat      temp0
;;;			bnt      code_0854
;;;			pushi    #highlight
;;;			pushi    2
;;;			lst      temp0
;;;			pushi    1
;;;			self     8
;;;			jmp      code_08b1
;;;code_0854:
;;;			pushi    #retreat
;;;			pushi    0
;;;			self     4
;;;			jmp      code_08b1
;;;code_085d:
;;;			dup     
;;;			ldi      5
;;;			eq?     
;;;			bnt      code_089d
;;;			pToa     highlightedIcon
;;;			bnt      code_0894
;;;			pushi    3
;;;			push    
;;;			pushi    #nsBottom
;;;			pushi    0
;;;			send     4
;;;			push    
;;;			ldi      1
;;;			add     
;;;			push    
;;;			pushi    #bottom
;;;			pushi    0
;;;			pToa     window
;;;			send     4
;;;			push    
;;;			call     localproc_0004,  6
;;;			sat      temp0
;;;			bnt      code_0894
;;;			pushi    #highlight
;;;			pushi    2
;;;			lst      temp0
;;;			pushi    1
;;;			self     8
;;;			jmp      code_08b1
;;;code_0894:
;;;			pushi    #advance
;;;			pushi    0
;;;			self     4
;;;			jmp      code_08b1
;;;code_089d:
;;;			dup     
;;;			ldi      0
;;;			eq?     
;;;			bnt      code_08b1
;;;			lst      temp2
;;;			ldi      4
;;;			and     
;;;			bnt      code_08b1
;;;			pushi    #advanceCurIcon
;;;			pushi    0
;;;			self     4
;;;code_08b1:
;;;			toss    
;;;			jmp      code_0a5e
;;;code_08b5:
;;;			lst      temp2
;;;			ldi      4
;;;			eq?     
;;;			bnt      code_08e6
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			dup     
;;;			ldi      9
;;;			eq?     
;;;			bnt      code_08d4
;;;			pushi    #advance
;;;			pushi    0
;;;			self     4
;;;			jmp      code_08e2
;;;code_08d4:
;;;			dup     
;;;			ldi      3840
;;;			eq?     
;;;			bnt      code_08e2
;;;			pushi    #retreat
;;;			pushi    0
;;;			self     4
;;;code_08e2:
;;;			toss    
;;;			jmp      code_0a5e
;;;code_08e6:
;;;			lst      temp2
;;;			ldi      16384
;;;			eq?     
;;;			bnt      code_0a5e
;;;			pushi    #firstTrue
;;;			pushi    2
;;;			pushi    196
;;;			lst      temp1
;;;			self     8
;;;			sat      temp0
;;;			bnt      code_0a5e
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			ldi      6
;;;			eq?     
;;;			bnt      code_099d
;;;			lat      temp0
;;;			bnt      code_0979
;;;			pushi    #helpStr
;;;			pushi    0
;;;			send     4
;;;			bnt      code_0979
;;;			pushi    #respondsTo
;;;			pushi    1
;;;			pushi    340
;;;			lag      gWindow
;;;			send     6
;;;			bnt      code_0962
;;;			pushi    #eraseOnly
;;;			pushi    0
;;;			lag      gWindow
;;;			send     4
;;;			sat      temp6
;;;			pushi    #eraseOnly
;;;			pushi    1
;;;			pushi    1
;;;			lag      gWindow
;;;			send     6
;;;			pushi    3
;;;			pushi    995
;;;			pushi    0
;;;			pushi    #helpStr
;;;			pushi    0
;;;			lat      temp0
;;;			send     4
;;;			push    
;;;			calle    proc255_4,  6
;;;			pushi    #eraseOnly
;;;			pushi    1
;;;			lst      temp6
;;;			lag      gWindow
;;;			send     6
;;;			jmp      code_0979
;;;code_0962:
;;;			pushi    3
;;;			pushi    995
;;;			pushi    0
;;;			pushi    #helpStr
;;;			pushi    0
;;;			lat      temp0
;;;			send     4
;;;			push    
;;;			calle    proc255_4,  6
;;;code_0979:
;;;			pushi    17
;;;			pushi    #superClass
;;;			pushi    #signal
;;;			pushi    0
;;;			pToa     helpIconItem
;;;			send     4
;;;			push    
;;;			ldi      65519
;;;			and     
;;;			push    
;;;			pToa     helpIconItem
;;;			send     6
;;;			pushi    #setCursor
;;;			pushi    1
;;;			pushi    999
;;;			lag      gGame
;;;			send     6
;;;			jmp      code_0a5e
;;;code_099d:
;;;			lst      temp0
;;;			pToa     okButton
;;;			eq?     
;;;			bnt      code_09aa
;;;			jmp      code_0a69
;;;			jmp      code_0a5e
;;;code_09aa:
;;;			pushi    #isKindOf
;;;			pushi    1
;;;			class    InvI
;;;			push    
;;;			lat      temp0
;;;			send     6
;;;			not     
;;;			bnt      code_09e2
;;;			pushi    #select
;;;			pushi    2
;;;			lst      temp0
;;;			lat      temp8
;;;			not     
;;;			push    
;;;			self     8
;;;			bnt      code_0a5e
;;;			lat      temp0
;;;			aTop     curIcon
;;;			pushi    #setCursor
;;;			pushi    2
;;;			pushi    #cursor
;;;			pushi    0
;;;			pToa     curIcon
;;;			send     4
;;;			push    
;;;			pushi    1
;;;			lag      gGame
;;;			send     8
;;;			jmp      code_0a5e
;;;code_09e2:
;;;			pToa     curIcon
;;;			bnt      code_0a5e
;;;			pushi    #respondsTo
;;;			pushi    1
;;;			pushi    340
;;;			lag      gWindow
;;;			send     6
;;;			bnt      code_0a09
;;;			pushi    #eraseOnly
;;;			pushi    0
;;;			lag      gWindow
;;;			send     4
;;;			sat      temp6
;;;			pushi    #eraseOnly
;;;			pushi    1
;;;			pushi    1
;;;			lag      gWindow
;;;			send     6
;;;code_0a09:
;;;			pushi    #isKindOf
;;;			pushi    1
;;;			class    InvI
;;;			push    
;;;			pToa     curIcon
;;;			send     6
;;;			bnt      code_0a34
;;;			pushi    #doVerb
;;;			pushi    2
;;;			pushi    #message
;;;			pushi    0
;;;			pToa     curIcon
;;;			send     4
;;;			push    
;;;			pushi    #indexOf
;;;			pushi    1
;;;			pTos     curIcon
;;;			self     6
;;;			push    
;;;			lat      temp0
;;;			send     8
;;;			jmp      code_0a46
;;;code_0a34:
;;;			pushi    #doVerb
;;;			pushi    1
;;;			pushi    #message
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			push    
;;;			lat      temp0
;;;			send     6
;;;code_0a46:
;;;			pushi    #respondsTo
;;;			pushi    1
;;;			pushi    340
;;;			lag      gWindow
;;;			send     6
;;;			bnt      code_0a5e
;;;			pushi    #eraseOnly
;;;			pushi    1
;;;			lst      temp6
;;;			lag      gWindow
;;;			send     6
;;;code_0a5e:
;;;			pushi    #dispose
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			jmp      code_062f
;;;code_0a69:
;;;			pushi    #dispose
;;;			pushi    0
;;;			lat      temp1
;;;			send     4
;;;			pushi    #hide
;;;			pushi    0
;;;			self     4
;;;			ret     
;;;		)
;;;	)
	
	(method (showSelf param1)
		(gSounds pause:)
		(if
		(and gPseudoMouse (gPseudoMouse respondsTo: #stop))
			(gPseudoMouse stop:)
		)
		(if (gIconBar height?) (gIconBar hide:))
		(if (not window)
			(= window (= window (SysWindow new:)))
		)
		(if (window window?)
			(window dispose:)
			(= window (= window 0))
		)
		(if (not okButton)
			(= okButton (= okButton (NodeValue (self first:))))
		)
		(= curIcon (= curIcon 0))
		(gGame setCursor: (selectIcon cursor?))
		(self show: (if argc param1 else gLarry) doit:)
	)
	
	(method (show param1 &tmp temp0)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(= state (= state (| state $0020)))
		(localproc_0089
			(if argc param1 else gLarry)
			(gIconBar curIcon?)
		)
		(PicNotValid temp0)
	)
	
	(method (hide)
		(if (& state $0020)
			(gSounds pause: 0)
			(= state (= state (& state $ffdf)))
		)
		(if window (window dispose:))
		(if
		(and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gIconBar curInvIcon?))
				(gIconBar enable: (gIconBar useIconItem?))
			)
			(gIconBar
				curIcon: ((gIconBar useIconItem?)
					cursor: (curIcon cursor?)
					yourself:
				)
				curInvIcon: curIcon
			)
		)
		(if ((gIconBar curIcon?) cursor?)
			(gGame setCursor: ((gIconBar curIcon?) cursor?) 1)
		)
	)
	
	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(+ temp1 (= temp2 (self indexOf: highlightedIcon)))
		)
		(repeat
			(= temp0
				(self
					at: (if (<= temp3 size) temp3 else (mod temp3 (- size 1)))
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(++ temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(- (= temp2 (self indexOf: highlightedIcon)) temp1)
		)
		(repeat
			(= temp0 (self at: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(-- temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (advanceCurIcon &tmp theCurIcon)
		(= theCurIcon curIcon)
		(while
			((= theCurIcon
				(self at: (mod (+ (self indexOf: theCurIcon) 1) size))
			)
				isKindOf: InvI
			)
		)
		(= curIcon (= curIcon theCurIcon))
		(gGame setCursor: (curIcon cursor?) 1)
	)
	
	(method (ownedBy param1)
		(self firstTrue: #ownedBy param1)
	)
)
