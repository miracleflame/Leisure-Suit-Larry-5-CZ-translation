;;; Sierra Script 1.0 - (do not remove this comment)
(script# 994)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Polygon)
(use Sound)
(use SRDialog)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(procedure (localproc_0004 param1 &tmp temp0 [temp1 40] [temp41 40] temp81)
	(= temp81 (Memory 1 (if 0 200 else 80)))
	(= temp0 1)
	(DeviceInfo 0 global29 @temp1)
	(DeviceInfo 1 @temp41)
	(if
		(and
			(DeviceInfo 3 @temp41)
			(or
				(DeviceInfo 2 @temp1 @temp41)
				(not (DeviceInfo 6 (gGame name?)))
			)
		)
		(Format
			temp81
			994
			3
			(if param1 {SAVE GAME} else {GAME})
			@temp1
		)
		(Load rsFONT global22)
		(DeviceInfo 4)
		(if
			(==
				(= temp0
					(if param1
						(proc255_0
							temp81
							33
							0
							81
							{OK}
							1
							81
							{Zrušit}
							0
							81
							{Zmìò adresáø}
							2
						)
					else
						(proc255_0 temp81 33 0 81 {OK} 1)
					)
				)
				2
			)
			(= temp0 (proc990_0 global29))
		)
	)
	(Memory 3 temp81)
	(return temp0)
)

(class Game of Obj
	(properties
		script 0
		parseLang 1
		printLang 1
		subtitleLang 0
		_detailLevel 3
		egoMoveSpeed 0
	)
	
	(method (init)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		(= gNewEventHandler 0)
		(= global29 (GetSaveDir))
		(Inv init:)
		(if (not gUser) (= gUser User))
		(gUser init:)
		(= global86 0)
	)
	
	(method (doit &tmp event evtTime)
		(= gCycleCnt (+ global86 (GetTime)))
		(if gNewEventHandler
			(= evtTime (+ gCycleCnt global79))
			(while gNewEventHandler
				(gNewEventHandler eachElementDo: #doit)
				(talkerEvent
					type: 0
					message: 0
					modifiers: 0
					y: 0
					x: 0
					claimed: 0
					port: 0
				)
				(GetEvent 32767 talkerEvent)
				(if
					(and
						(talkerEvent type:)
						gNewEventHandler
						(> (= gCycleCnt (+ global86 (GetTime))) evtTime)
					)
					(gNewEventHandler firstTrue: #handleEvent talkerEvent)
				)
			)
		else
			(gSounds eachElementDo: #check)
			(gTimers eachElementDo: #doit)
			(if gTheNewDialog
				(gTheNewDialog check:)
			)
			(Animate (gCast elements:) 1)
			(if global37
				(= global37 0)
				(gCast eachElementDo: #motionCue)
			)
			(if script
				(script doit:)
			)
			(gRegions eachElementDo: #doit)
			(if (== gNewRoomNumber gNumber)
				(gUser doit:)
			)
			(gTheDoits doit:)
			(if (!= gNewRoomNumber gNumber)
				(self newRoom: gNewRoomNumber)
			)
			(gTimers eachElementDo: #delete)
			(GameIsRestarting 0)
		)
	)
;;;	(method (doit &tmp temp0 temp1)
;;;		(asm
;;;			lsg      global86
;;;			pushi    0
;;;			callk    GetTime,  0
;;;			add     
;;;			sag      gCycleCnt
;;;			lag      gNewEventHandler
;;;			bnt      code_0343
;;;			lsg      gCycleCnt
;;;			lag      global79
;;;			add     
;;;			sat      temp1
;;;code_02c7:
;;;			lag      gNewEventHandler
;;;			bnt      code_03d2
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    60
;;;			send     6
;;;			pushi    #type
;;;			pushi    1
;;;			pushi    0
;;;			pushi    40
;;;			pushi    1
;;;			pushi    0
;;;			pushi    64
;;;			pushi    1
;;;			pushi    0
;;;			pushi    3
;;;			pushi    1
;;;			pushi    0
;;;			pushi    4
;;;			pushi    1
;;;			pushi    0
;;;			pushi    76
;;;			pushi    1
;;;			pushi    0
;;;			pushi    143
;;;			pushi    1
;;;			pushi    0
;;;			lofsa    talkerEvent
;;;			send     42
;;;			pushi    2
;;;			pushi    32767
;;;			lofsa    talkerEvent
;;;			push    
;;;			callk    GetEvent,  4
;;;			pushi    #type
;;;			pushi    0
;;;			lofsa    talkerEvent
;;;			send     4
;;;			bnt      code_02c7
;;;			lag      gNewEventHandler
;;;			bnt      code_02c7
;;;			lsg      global86
;;;			pushi    0
;;;			callk    GetTime,  0
;;;			add     
;;;			sag      gCycleCnt
;;;			push    
;;;			lat      temp1
;;;			gt?     
;;;			bnt      code_02c7
;;;			pushi    #firstTrue
;;;			pushi    2
;;;			pushi    129
;;;			lofsa    talkerEvent
;;;			push    
;;;			lag      gNewEventHandler
;;;			send     8
;;;			jmp      code_02c7
;;;			jmp      code_03d2
;;;code_0343:
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    164
;;;			lag      gSounds
;;;			send     6
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    60
;;;			lag      gTimers
;;;			send     6
;;;			lag      gTheNewDialog
;;;			bnt      code_0363
;;;			pushi    #check
;;;			pushi    0
;;;			send     4
;;;code_0363:
;;;			pushi    2
;;;			pushi    #elements
;;;			pushi    0
;;;			lag      gCast
;;;			send     4
;;;			push    
;;;			pushi    1
;;;			callk    Animate,  4
;;;			lag      global37
;;;			bnt      code_0386
;;;			ldi      0
;;;			sag      global37
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    218
;;;			lag      gCast
;;;			send     6
;;;code_0386:
;;;			pToa     script
;;;			bnt      code_0390
;;;			pushi    #doit
;;;			pushi    0
;;;			send     4
;;;code_0390:
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    60
;;;			lag      gRegions
;;;			send     6
;;;			lsg      gNewRoomNumber
;;;			lag      gNumber
;;;			eq?     
;;;			bnt      code_03a9
;;;			pushi    #doit
;;;			pushi    0
;;;			lag      gUser
;;;			send     4
;;;code_03a9:
;;;			pushi    #doit
;;;			pushi    0
;;;			lag      gTheDoits
;;;			send     4
;;;			lsg      gNewRoomNumber
;;;			lag      gNumber
;;;			ne?     
;;;			bnt      code_03c1
;;;			pushi    #newRoom
;;;			pushi    1
;;;			lsg      gNewRoomNumber
;;;			self     6
;;;code_03c1:
;;;			pushi    #eachElementDo
;;;			pushi    1
;;;			pushi    84
;;;			lag      gTimers
;;;			send     6
;;;			pushi    1
;;;			pushi    0
;;;			callk    GameIsRestarting,  2
;;;code_03d2:
;;;			ret     
;;;		)
;;;	)
	
	(method (play)
		(= gGame self)
		(= global29 (GetSaveDir))
		(if (not (GameIsRestarting)) (GetCWD global29))
		(self setCursor: global21 1 init:)
		(while (not global4)
			(self doit:)
		)
	)
	
	(method (replay)
		(if gPEvent (gPEvent dispose:))
		(gSFeatures release:)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: global21 1)
		(DrawPic
			(global2 curPic?)
			100
			dpCLEAR
			global40
		)
		(if (!= gPicNumber -1)
			(DrawPic
				gPicNumber
				100
				dpNO_CLEAR
				global40
			)
		)
		(if (global2 controls?) ((global2 controls?) draw:))
		(gAddToPics doit:)
		(gGame
			setCursor:
				(if (and gIconBar (gIconBar curIcon?))
					((gIconBar curIcon?) cursor?)
				else
					global20
				)
				(HaveMouse)
		)
		(SL doit:)
		(DoSound 2)
		(Sound pause: 0)
		(= global86 (- gCycleCnt (GetTime)))
		(while (not global4)
			(self doit:)
		)
	)
	
	(method (newRoom newRoomNumber &tmp [temp0 5] temp5)
		(gAddToPics eachElementDo: #dispose release:)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(gTheDoits release:)
		(Animate 0)
		(= gGNumber gNumber)
		(= gNumber newRoomNumber)
		(= gNewRoomNumber newRoomNumber)
		(FlushResources newRoomNumber)
		(self startRoom: gNumber checkAni:)
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: 3)) type?)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)
	
	(method (startRoom param1)
		(if global14 (SetDebug))
		(gRegions addToFront: (= global2 (ScriptID param1)))
		(global2 init:)
	)
	
	(method (restart)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(RestartGame)
	)
	
	(method (restore &tmp [temp0 20] temp20 temp21 theParseLang)
		(= theParseLang parseLang)
		(= parseLang (= parseLang 1))
		(Load rsFONT global23)
		(Load rsCURSOR global21)
		(ScriptID 990)
		(Sound pause: 1)
		(if (localproc_0004 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(= temp21 (self setCursor: global20))
			(= temp20 (Restore doit: &rest))
			(self setCursor: temp21 1)
			(if (!= temp20 -1)
				(= temp21 (self setCursor: global21 1))
				(if (CheckSaveGame name temp20 global27)
					(RestoreGame name temp20 global27)
				else
					(proc255_0 994 1 33 0 81 {OK} 1)
					(self setCursor: temp21 (HaveMouse))
					(= parseLang (= parseLang theParseLang))
				)
			else
				(= parseLang (= parseLang theParseLang))
			)
			(localproc_0004 0)
		)
		(Sound pause: 0)
	)
	
	(method (save &tmp [temp0 20] temp20 temp21 theParseLang)
		(= theParseLang parseLang)
		(= parseLang (= parseLang 1))
		(Load rsFONT global23)
		(Load rsCURSOR global21)
		(ScriptID 990)
		(Sound pause: 1)
		(if (localproc_0004 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(= temp21 (self setCursor: global20))
			(= temp20 (Save doit: @temp0))
			(self setCursor: temp21 1)
			(if (!= temp20 -1)
				(= parseLang (= parseLang theParseLang))
				(= temp21 (self setCursor: global21 1))
				(if (not (SaveGame name temp20 @temp0 global27))
					(proc255_0 994 0 33 0 81 {OK} 1)
				)
				(self setCursor: temp21 1)
			)
			(localproc_0004 0)
		)
		(Sound pause: 0)
		(= parseLang (= parseLang theParseLang))
	)
	
	(method (changeScore param1)
		(= global15 (+ global15 param1))
		(SL doit:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) 1)
			((and script (script handleEvent: pEvent)) 1)
			((== (pEvent type?) $4000) (self pragmaFail:))
		)
		(pEvent claimed?)
	)
	
	(method (showMem)
		(proc255_4
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1)
			(MemoryInfo 0)
			(>> (MemoryInfo 3) $0006)
			(MemoryInfo 2)
		)
	)
	
	(method (setSpeed newSpeed &tmp theGNewSpeed)
		(= theGNewSpeed gNewSpeed)
		(= gNewSpeed newSpeed)
		(return theGNewSpeed)
	)
	
	(method (setCursor cursorNumber &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(= gCursorNumber cursorNumber)
		(SetCursor cursorNumber &rest)
		(return theGCursorNumber)
	)
	
	(method (checkAni &tmp temp0)
		(Animate (gCast elements?) 0)
		(Wait 0)
		(Animate (gCast elements?) 0)
		(while (> (Wait 0) global30)
			(if (== (= temp0 (gCast firstTrue: #isExtra)) 0)
				(break)
			)
			(temp0 addToPic:)
			(Animate (gCast elements?) 0)
			(gCast eachElementDo: #delete)
		)
	)
	
	(method (notify)
	)
	
	(method (setScript theScript)
		(if script (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (quitGame param1)
		(if (or (not argc) param1) (= global4 1))
	)
	
	(method (masterVolume param1)
		(if argc
			(DoSound 0 param1)
		else
			(DoSound 0)
		)
	)
	
	(method (detailLevel the_detailLevel)
		(if argc
			(= _detailLevel (= _detailLevel the_detailLevel))
			(gCast eachElementDo: #checkDetail)
		)
		(return _detailLevel)
	)
	
	(method (pragmaFail)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		lookStr 0
	)
	
	(method (init)
		(if (not initialized)
			(= initialized (= initialized 1))
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script) (script dispose:))
		(if (IsObject timer) (timer dispose:))
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) 1)
			(
				(not
					(if
					(and script (or (script handleEvent: pEvent) 1))
						(pEvent claimed?)
					)
				)
				(pEvent
					claimed:
						(self
							doVerb:
								(pEvent message?)
								(if
								(and gInv gIconBar (== (pEvent message?) JOY_DOWNRIGHT))
									(gInv indexOf: (gIconBar curInvIcon?))
								else
									0
								)
						)
				)
			)
		)
		(pEvent claimed?)
	)
	
	(method (doVerb theVerb)
		(return
			(if (and (== theVerb 2) lookStr)
				(proc255_4 994 2 lookStr)
				(return 1)
			else
				(return 0)
			)
		)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (newRoom)
	)
	
	(method (notify)
	)
)

(class Rm of Rgn
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		lookStr 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		obstacles 0
	)
	
	(method (init &tmp temp0)
		(= number (= number gNumber))
		(= controls (= controls controls))
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(self
			reflectPosn: (gUser alterEgo?) ((gUser alterEgo?) edgeHit?)
		)
		((gUser alterEgo?) edgeHit: 0)
	)
	
	(method (doit &tmp temp0)
		(if script (script doit:))
		(if
			(= temp0
				(self edgeToRoom: ((gUser alterEgo?) edgeHit?))
			)
			(self newRoom: temp0)
		)
	)
	
	(method (dispose)
		(if controls (controls dispose:))
		(if obstacles (obstacles dispose:))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			(controls (controls handleEvent: pEvent))
		)
		(pEvent claimed?)
	)
	
	(method (newRoom newRoomNumber)
		(gRegions
			delete: self
			eachElementDo: #newRoom newRoomNumber
			addToFront: self
		)
		(= gNewRoomNumber newRoomNumber)
		(super newRoom: newRoomNumber)
	)
	
	(method (setRegions scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gRegions add: temp2)
			(if (not (temp2 initialized?)) (temp2 init:))
			(++ temp0)
		)
	)
	
	(method (setFeatures theFeatures &tmp temp0 [temp1 2])
		(= temp0 0)
		(while (< temp0 argc)
			(gFeatures add: [theFeatures temp0])
			(++ temp0)
		)
	)
	
	(method (setLocales scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gLocales add: temp2)
			(temp2 init:)
			(++ temp0)
		)
	)
	
	(method (drawPic picNumber picAnimation)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(= curPic (= curPic picNumber))
		(= gPicNumber -1)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpCLEAR
			global40
		)
	)
	
	(method (overlay picNumber picAnimation)
		(= gPicNumber picNumber)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpNO_CLEAR
			global40
		)
	)
	
	(method (addObstacle param1)
		(if (not (IsObject obstacles))
			(= obstacles (= obstacles (List new:)))
		)
		(obstacles add: param1 &rest)
	)
	
	(method (reflectPosn param1 param2)
		(switch param2
			(1 (param1 y: 188))
			(4
				(param1 x: (- 319 (param1 xStep?)))
			)
			(3
				(param1 y: (+ horizon (param1 yStep?)))
			)
			(2 (param1 x: 1))
		)
	)
	
	(method (edgeToRoom param1)
		(switch param1
			(1 north)
			(2 east)
			(3 south)
			(4 west)
		)
	)
	
	(method (roomToEdge param1)
		(switch param1
			(north 1)
			(south 3)
			(east 2)
			(west 4)
		)
	)
)

(class Locale of Obj
	(properties
		number 0
	)
	
	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)
	
	(method (handleEvent pEvent)
		(pEvent claimed?)
	)
)

(class SL of Obj
	(properties
		state $0000
		code 0
	)
	
	(method (doit &tmp temp0)
		(if code
			(= temp0 (Memory 1 (if 0 240 else 82)))
			(code doit: temp0)
			(DrawStatus (if state temp0 else 0))
			(Memory 3 temp0)
		)
	)
	
	(method (enable)
		(= state (= state 1))
		(self doit:)
	)
	
	(method (disable)
		(= state (= state 0))
		(self doit:)
	)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
	(properties)
)

(instance sFeatures of EventHandler
	(properties)
	
	(method (delete param1)
		(super delete: param1)
		(if
			(and
				global34
				(param1 isKindOf: Collect)
				(not (proc999_5 param1 gRegions gLocales))
			)
			(param1 release: dispose:)
		)
	)
)

(instance sounds of EventHandler
	(properties)
	
	(method (pause param1)
		(self
			eachElementDo: #perform mayPause (if argc param1 else 1)
		)
	)
)

(instance mayPause of Code
	(properties)
	
	(method (doit param1 param2)
		(if (not (& (param1 flags?) $0001))
			(param1 pause: param2)
		)
	)
)

(instance regions of EventHandler
	(properties)
)

(instance locales of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)
	
	(method (doit)
		(self eachElementDo: #perform aTOC)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(instance aTOC of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1)
		(if (not (| (param1 signal?) $4000))
			(= temp0
				(+ (gLarry xStep?) (/ (CelWide (gLarry view?) 2 0) 2))
			)
			(= temp1 (* (gLarry yStep?) 2))
			(global2
				addObstacle:
					((Polygon new:)
						init:
							(- (param1 brLeft?) temp0)
							(- (CoordPri 1 (CoordPri (param1 y?))) temp1)
							(+ (param1 brRight?) temp0)
							(- (CoordPri 1 (CoordPri (param1 y?))) temp1)
							(+ (param1 brRight?) temp0)
							(+ (param1 y?) temp1)
							(- (param1 brLeft?) temp0)
							(+ (param1 y?) temp1)
						yourself:
					)
			)
		)
	)
)

(instance RU of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 underBits?)
			(= temp0
				(&
					(= temp0 (| (= temp0 (param1 signal?)) $0001))
					$fffb
				)
			)
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)
	
	(method (doit param1)
		(if (not (param1 keep?)) (param1 dispose:))
	)
)

(instance fDC of Code
	(properties)
	
	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1
				signal: (& (param1 signal?) $ffdf)
				dispose:
				delete:
			)
		else
			(param1 dispose:)
		)
	)
)

(instance talkerEvent of Event
	(properties)
)
