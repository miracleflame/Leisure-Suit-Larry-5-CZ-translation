;;; Sierra Script 1.0 - (do not remove this comment)
(script# 20)
(include sci.sh)
(use Main)
(use Timer)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	TTDialer 0
)

(local
	[local0 100]
	local100
	[local101 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[local115 14] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3]
	[local129 6] = [551 552 553 554 555 556]
	[local135 10]
	local145
	local146
	local147
	local148
	userCanInput
	gLongSongVol
	gLongSong2Vol
	local152
	local153
	local154
	local155
)
(instance TTDialer of Prop
	(properties
		x 275
		y 89
		view 10
		priority 14
		signal $0010
	)
	
	(method (init param1 param2)
		(switch gNumber
			(258 (= x 41) (= y 189))
			(870 (= x 41) (= y 89))
			(else  (= x 275) (= y 89))
		)
		(= local147 param1)
		(if (> argc 1) (= local148 param2) else (= local148 0))
		(= local0 0)
		(= local100 0)
		(= local145 0)
		(= local146 0)
		(= userCanInput (User canInput:))
		(= local152 global169)
		(if
		(!= (= local153 ((gIconBar at: 0) cursor?)) 6)
			(proc0_22 1)
		)
		(proc0_2)
		(User canInput: 1 mapKeyToDir: 0)
		(gIconBar enable: 0 2 curIcon: (gIconBar at: 2))
		(gGame setCursor: 2)
		(if (gLongSong handle?)
			(= gLongSongVol (gLongSong vol?))
			(gLongSong setVol: (/ gLongSongVol 2))
		)
		(if (gLongSong2 handle?)
			(= gLongSong2Vol (gLongSong2 vol?))
			(gLongSong2 setVol: (/ gLongSong2Vol 2))
		)
		(if (== local147 1)
			(dialToneSound
				number: 33
				loop: -1
				flags: 1
				play:
				hold: 10
			)
		)
		(super init: stopUpd:)
		(btn0 init: stopUpd:)
		(btn1 init: stopUpd:)
		(btn2 init: stopUpd:)
		(btn3 init: stopUpd:)
		(btn4 init: stopUpd:)
		(btn5 init: stopUpd:)
		(btn6 init: stopUpd:)
		(btn7 init: stopUpd:)
		(btn8 init: stopUpd:)
		(btn9 init: stopUpd:)
		(if (== local147 1)
			(btnStar init: stopUpd:)
			(btnCross init: stopUpd:)
			(hangUp init: stopUpd:)
		)
		(gLl5MDHandler addToEnd: self)
		(gLl5KDHandler addToEnd: self)
	)
	
	(method (dispose)
		(gIconBar disable:)
		(User canInput: 0 canControl: 0)
		(btn0 dispose:)
		(btn1 dispose:)
		(btn2 dispose:)
		(btn3 dispose:)
		(btn4 dispose:)
		(btn5 dispose:)
		(btn6 dispose:)
		(btn7 dispose:)
		(btn8 dispose:)
		(btn9 dispose:)
		(if (== local147 1)
			(btnStar dispose:)
			(btnCross dispose:)
			(hangUp dispose:)
		)
		(self hide:)
		(= local100 254)
		(hangUpTimer setReal: self 2)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((not (User canInput:)))
			((pEvent modifiers?) (super handleEvent: pEvent))
			(
				(or
					(and
						(proc999_5 (pEvent type?) 1 4)
						(== ((gIconBar at: 0) cursor?) 6)
						(== (gIconBar curIcon?) (gIconBar at: 0))
					)
					(== (pEvent message?) JOY_UP)
				)
				(pEvent claimed: 1)
				(= local154 -1)
				(self dispose:)
			)
			(else (pEvent claimed: 1))
		)
	)
	
	(method (cue &tmp temp0)
		(switch (++ local100)
			(1
				(if
				(and (== local147 1) (not (ReadNumber @local0)))
					(self setScript: sInformation)
				)
			)
			(3
				(if (== local147 1)
					(= local145 (ReadNumber @local0))
					(= local0 0)
					(if (proc999_5 local145 411 911)
						(self setScript: sInformation)
					)
				)
			)
			(5
				(if (== local147 0)
					(if (not (StrCmp @local0 {!!!!!}))
						(= local154 -2)
					else
						(= local154 (ReadNumber @local0))
					)
					(self dispose:)
				)
			)
			(7
				(= local146 (ReadNumber @local0))
				(if
					(and
						(== local147 1)
						(== local145 555)
						(== local146 1212)
					)
					(self setScript: sInformation)
				else
					(User canInput: 0)
					(self setScript: sMessage self)
				)
			)
			(8
				(if local146
					(= local154 local146)
					(self dispose:)
				else
					(= local0 0)
					(= local100 0)
					(= local145 0)
					(= local146 0)
				)
			)
			(255
				(= temp0 0)
				(while (< temp0 10)
					(= [local135 temp0] 0)
					(++ temp0)
				)
				(User canInput: userCanInput mapKeyToDir: 1)
				(if (!= local153 6) (proc0_22 0))
				(proc0_16)
				(= global169 local152)
				(if (gLongSong handle?)
					(gLongSong setVol: gLongSongVol)
				)
				(if (gLongSong2 handle?)
					(gLongSong2 setVol: gLongSong2Vol)
				)
				(gLl5MDHandler delete: self)
				(gLl5KDHandler delete: self)
				(global2 notify: local154)
				(if local148 (local148 cue:))
				(dialToneSound stop:)
				(hangUpTimer dispose: delete:)
				(gIconBar enable: curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(super dispose:)
			)
		)
	)
)

(instance sMessage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and
							(!= gNumber 200)
							(== local145 [local129 global160])
						)
						(and (== gNumber 200) (== local145 556))
					)
					(= register 1)
				)
				(if (!= register 1)
					(phoneSound number: 35 play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (!= register 1)
					(proc0_14 20 0)
					(proc0_14 20 1)
					(proc0_14 20 2 67 -1 185)
					(= local146 0)
				else
					(proc0_14 20 3)
				)
				(User canInput: 1)
				(= local154 local146)
				(client dispose:)
			)
		)
	)
)

(instance sInformation of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 222])
		(switch (= state newState)
			(0 (= ticks 120))
			(1
				(Format
					@temp0
					20
					4
					(if (== global2 200)
						{Washington, D. C.}
					else
						(switch global160
							(1 {New York City Metropolitan})
							(2
								{Atlantic City, Trampem nezamoøená oblast}
							)
							(3 {Dade County})
							(else  {'Tady zadejte své mìsto'})
						)
					)
					(if (== global2 200)
						{plavba po øece Potomac}
					else
						(switch global160
							(1 {je pøepaden})
							(2 {krmí automaty})
							(3 {leží na pláži})
							(else  {sedí na záchodì!})
						)
					)
				)
				(proc0_14 @temp0)
				(= cycles 1)
			)
			(2
				(= local0 0)
				(= local100 0)
				(= local145 0)
				(= local146 0)
				(= local154 -1)
				(client dispose:)
			)
		)
	)
)

(instance dialToneSound of Sound
	(properties)
)

(instance phoneSound of Sound
	(properties)
)

(instance hangUpTimer of Timer
	(properties)
)

(class PushButton of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 14
		underBits 0
		signal $0010
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		keyValue 45
		scanValue 0
		keyStr {x}
		tone 0
	)
	
	(method (init &tmp theLoop)
		(= x (+ (TTDialer x?) [local101 loop]))
		(= y (+ (TTDialer y?) [local115 loop] 1000))
		(if (== gNumber 258)
			(= view 11)
			(= theLoop (Random 1 10))
			(while [local135 theLoop]
				(= theLoop (Random 1 10))
			)
			(= [local135 theLoop] 1)
			(= loop theLoop)
		else
			(= view 10)
		)
		(super init:)
		(gLl5MDHandler addToFront: self)
		(gLl5KDHandler addToFront: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp [temp0 10] pEventType pEventMessage temp12)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(if
			(or
				(and (== pEventType evMOUSEBUTTON) (self onMe: pEvent))
				(and
					(== pEventType evKEYBOARD)
					(== pEventMessage KEY_RETURN)
					(self onMe: pEvent)
				)
				(and
					(== pEventType evKEYBOARD)
					(proc999_5 pEventMessage keyValue scanValue)
				)
			)
			(pEvent claimed: 1)
			(dialToneSound stop:)
			(if (== loop 13)
				(= local154 -1)
				(TTDialer dispose:)
			else
				(if (and (== (pEvent modifiers?) 12) (== loop 1))
					(= keyStr {!})
				else
					(switch loop
						(11 (= keyStr {#}))
						(12 (= keyStr {*}))
						(else 
							(Format keyStr 20 5 (- loop 1))
						)
					)
				)
				(= temp12 (if (== gNumber 258) 256 else tone))
				(self setScript: (sButton new:) 0 temp12)
			)
		)
	)
)

(instance sButton of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if register
					(phoneSound number: register play:)
				)
				(= cycles 1)
			)
			(2
				(StrCat @local0 (client keyStr?))
				(TTDialer cue:)
				(client setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance btn0 of PushButton
	(properties
		z 1000
		loop 1
		keyValue 48
		scanValue 20992
		keyStr {x}
		tone 30
	)
)

(instance btn1 of PushButton
	(properties
		z 1000
		loop 2
		keyValue 49
		scanValue 20224
		keyStr {x}
		tone 21
	)
	
	(method (init)
		(= keyValue (if (== gNumber 258) 55 else 49))
		(= scanValue (if (== gNumber 258) 18176 else 20224))
		(super init:)
	)
)

(instance btn2 of PushButton
	(properties
		z 1000
		loop 3
		keyValue 50
		scanValue 20480
		keyStr {x}
		tone 22
	)
	
	(method (init)
		(= keyValue (if (== gNumber 258) 56 else 50))
		(= scanValue (if (== gNumber 258) 18432 else 20480))
		(super init:)
	)
)

(instance btn3 of PushButton
	(properties
		z 1000
		loop 4
		keyValue 51
		scanValue 20736
		keyStr {x}
		tone 23
	)
	
	(method (init)
		(= keyValue (if (== gNumber 258) 57 else 51))
		(= scanValue (if (== gNumber 258) 18688 else 20736))
		(super init:)
	)
)

(instance btn4 of PushButton
	(properties
		z 1000
		loop 5
		keyValue 52
		scanValue 19200
		keyStr {x}
		tone 24
	)
)

(instance btn5 of PushButton
	(properties
		z 1000
		loop 6
		keyValue 53
		scanValue 19456
		keyStr {x}
		tone 25
	)
)

(instance btn6 of PushButton
	(properties
		z 1000
		loop 7
		keyValue 54
		scanValue 19712
		keyStr {x}
		tone 26
	)
)

(instance btn7 of PushButton
	(properties
		z 1000
		loop 8
		keyValue 55
		scanValue 18176
		keyStr {x}
		tone 27
	)

	(method (init)
		(= keyValue (if (== gNumber 258) 49 else 55))
		(= scanValue (if (== gNumber 258) 20224 else 18176))
		(super init:)
	)
)

(instance btn8 of PushButton
	(properties
		z 1000
		loop 9
		keyValue 56
		scanValue 18432
		keyStr {x}
		tone 28
	)
	
	(method (init)
		(= keyValue (if (== gNumber 258) 50 else 56))
		(= scanValue (if (== gNumber 258) 20480 else 18432))
		(super init:)
	)
)

(instance btn9 of PushButton
	(properties
		z 1000
		loop 10
		keyValue 57
		scanValue 18688
		keyStr {x}
		tone 29
	)
	
	(method (init)
		(= keyValue (if (== gNumber 258) 51 else 57))
		(= scanValue (if (== gNumber 258) 20736 else 18688))
		(super init:)
	)
)

(instance btnCross of PushButton
	(properties
		z 1000
		loop 11
		keyValue 35
		keyStr {x}
		tone 31
	)
)

(instance btnStar of PushButton
	(properties
		z 1000
		loop 12
		keyValue 42
		keyStr {x}
		tone 32
	)
)

(instance hangUp of PushButton
	(properties
		z 1000
		loop 13
		keyValue 32
		keyStr {x}
	)
)
